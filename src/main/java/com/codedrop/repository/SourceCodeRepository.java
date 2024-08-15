package com.codedrop.repository;

import com.codedrop.entity.SourceCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceCodeRepository extends JpaRepository<SourceCode, Integer> {
}