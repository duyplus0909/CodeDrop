package com.codedrop.controller;

import com.codedrop.model.User;
import com.codedrop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder pe;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> user = userService.findAll();
        if (user.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") int id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        user.setPassword(pe.encode(user.getPassword()));
        return userService.create(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user) {
        User update = userService.findById(id);
        user.setPassword(pe.encode(user.getPassword()));
        userService.update(user);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        User user = userService.findById(id);
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
