package com.codedrop.controller;

import com.codedrop.dto.UserDto;
import com.codedrop.exception.ResourceNotFoundException;
import com.codedrop.model.User;
import com.codedrop.payload.JwtResponse;
import com.codedrop.payload.JwtTokenUtil;
import com.codedrop.service.AuthService;
import com.codedrop.service.MailerService;
import com.codedrop.service.impl.UserDetailsImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsImpl userDetailsService;

    @Autowired
    MailerService mailerService;

    @Autowired
    AuthService authService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("auth/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) throws Exception {
        authenticate(userDto.getUsername(), userDto.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("auth/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(userDto));
    }

    @PostMapping("auth/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestBody String email) {
        if (authService.sendResetMail(email)) {
            return ResponseEntity.ok().build();
        }
        throw new ResourceNotFoundException("User not exists with email: " + email);
    }

    @SneakyThrows
    @GetMapping("auth/reset-password")
    public ResponseEntity<User> resetPassword(@RequestParam Optional<String> token) {
        ResourceNotFoundException exception = new ResourceNotFoundException("Cannot find token: " + token);
        String tokenVal = token.orElseThrow(() -> exception);
        User user = authService.findByToken(tokenVal);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        throw exception;
    }

    @PostMapping("auth/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody User user) throws Exception {
        authenticate(user.getUsername(), user.getPassword());
        return authService.changePassword(user) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
