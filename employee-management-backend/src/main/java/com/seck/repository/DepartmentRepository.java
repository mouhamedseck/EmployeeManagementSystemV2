package com.seck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seck.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
