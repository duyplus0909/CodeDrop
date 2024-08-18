package com.codedrop.service;

import com.codedrop.model.User;
import org.springframework.stereotype.Component;

@Component
public interface AuthService {

    boolean sendResetMail(String email);

    User findByToken(String token);

    boolean changePassword(User user);
}
