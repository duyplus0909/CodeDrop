package com.codedrop.service;

import com.codedrop.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    User create(User user);

    User update(User user);

    void delete(User user);

    User findUsernameByEmail(String email);

    User findByEmail(String email);

    User findByToken(String token);

//    void loginOAuth2(OAuth2AuthenticationToken oauth2);
}
