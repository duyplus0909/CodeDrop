package com.codedrop.controller;

import com.codedrop.model.Authority;
import com.codedrop.model.Role;
import com.codedrop.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/authority")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @GetMapping
    public ResponseEntity<List<Authority>> getAll() {
        List<Authority> authorities = authorityService.findAll();
        if (authorities.isEmpty()) {
            return new ResponseEntity<List<Authority>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Authority>>(authorities, HttpStatus.OK);
    }

    @PostMapping
    public Authority create(@RequestBody Authority auth) {
        return authorityService.create(auth);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityService.delete(id);
    }
}
