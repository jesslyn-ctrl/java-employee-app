package com.app.employee.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.employee.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// Get employee data by id
	Optional<Employee> findById(Long id);
}
