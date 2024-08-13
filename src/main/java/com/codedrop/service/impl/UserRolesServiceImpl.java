package com.codedrop.service.impl;

import com.codedrop.entity.Authority;
import com.codedrop.entity.User;
import com.codedrop.repository.AuthorityRepository;
import com.codedrop.repository.UserRepository;
import com.codedrop.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesServiceImpl implements AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<User> customers = userRepository.getAdministrators();
        return authorityRepository.authoritiesOf(customers);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return authorityRepository.save(auth);
    }

    @Override
    public void delete(Integer id) {
        authorityRepository.deleteById(id);
    }

}
