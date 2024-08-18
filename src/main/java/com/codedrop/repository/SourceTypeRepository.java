package com.codedrop.repository;

import com.codedrop.model.SourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceTypeRepository extends JpaRepository<SourceType, Integer> {
}