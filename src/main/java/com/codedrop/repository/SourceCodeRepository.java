package com.codedrop.repository;

import com.codedrop.model.SourceCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceCodeRepository extends JpaRepository<SourceCode, Integer> {
}