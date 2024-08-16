package com.codedrop.security;

import com.codedrop.model.User;
import com.codedrop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;
    private final HttpSession session;

    public SecurityConfig(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder pe) {
        return username -> {
            try {
                User user = userService.findById(Integer.valueOf(username));
                String password = pe.encode(user.getPassword());
                String[] roles = user.getAuthorities().stream()
                        .map(er -> er.getRole().getId())
                        .toList()
                        .toArray(new String[0]);
                Map<String, Object> authentication = new HashMap<>();
                authentication.put("user", user);
                byte[] token = (username + ":" + user.getPassword()).getBytes();
                authentication.put("token", "Basic " + Base64.getEncoder().encodeToString(token));
                session.setAttribute("authentication", authentication);
                return org.springframework.security.core.userdetails.User.withUsername(username).password(password).roles(roles).build();
            } catch (NoSuchElementException e) {
                throw new UsernameNotFoundException(username + " not found!");
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder pe, UserDetailsService userDetailsService) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(userDetailsService).passwordEncoder(pe);
        return authBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeRequests(authorize -> authorize
                .requestMatchers("/auth/change-password").authenticated()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/rest/authorities").hasRole("ADMIN")
                .anyRequest().permitAll()
        );
        http.formLogin(form -> form
                .loginPage("/auth/login/form")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/auth/login/success", false)
                .failureUrl("/auth/login/error")
        );
        http.rememberMe(rememberMe -> rememberMe.tokenValiditySeconds(86400));
        http.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/auth/unauthoried"));
        http.logout(logout -> logout
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/auth/logout/success")
        );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(HttpMethod.OPTIONS, "/**");
    }
}