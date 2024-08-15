package com.codedrop.repository;

import com.codedrop.entity.CommentSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentSourceRepository extends JpaRepository<CommentSource, Integer> {
}