package com.codedrop.rest;

import com.codedrop.entity.User;
import com.codedrop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return userService.getAdministrators();
        }
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}
