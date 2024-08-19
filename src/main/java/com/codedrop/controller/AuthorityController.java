package com.codedrop.controller;

import com.codedrop.model.Authority;
import com.codedrop.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/authority")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @PostMapping
    public Authority create(@RequestBody Authority auth) {
        return authorityService.create(auth);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityService.delete(id);
    }
}
