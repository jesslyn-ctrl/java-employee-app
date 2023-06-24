package com.app.employee.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.employee.models.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{
	// Get grade data by code
	Optional<Grade> findByCode(int code);
}
