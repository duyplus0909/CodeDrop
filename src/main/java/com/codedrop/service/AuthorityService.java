package com.codedrop.service;

import com.codedrop.model.Authority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorityService {

    public List<Authority> findAuthoritiesOfAdministrators();

    public List<Authority> findAll();

    public Authority create(Authority auth);

    public void delete(Integer id);
}
