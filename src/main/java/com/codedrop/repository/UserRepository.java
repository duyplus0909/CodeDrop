package com.codedrop.repository;

import com.codedrop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT DISTINCT a.user FROM Authority a WHERE a.role.id IN('ADMIN')")
    List<User> getAdministrators();

    @Query("SELECT u FROM User u WHERE u.email=?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.token=?1")
    public User findByToken(String token);
}