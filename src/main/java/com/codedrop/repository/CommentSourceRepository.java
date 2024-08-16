package com.codedrop.repository;

import com.codedrop.model.CommentSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentSourceRepository extends JpaRepository<CommentSource, Integer> {
}