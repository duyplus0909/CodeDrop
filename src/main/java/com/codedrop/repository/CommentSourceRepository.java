package com.codedrop.repository;

import com.codedrop.model.CommentSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentSourceRepository extends JpaRepository<CommentSource, Integer> {
}