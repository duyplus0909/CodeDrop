package com.codedrop.service;

import com.codedrop.entity.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    List<User> findAll();

    List<User> getAdministrators();

    User create(User user);

    User update(User users);

    void delete(Integer id);

//    void loginFromOAuth2(OAuth2AuthenticationToken oauth2);

    void updateToken(String token, String email) throws Exception;

    User getByToken(String token);

    void updatePassword(User user, String newPassword);

    void changePassword(User user, String newPassword);
}
