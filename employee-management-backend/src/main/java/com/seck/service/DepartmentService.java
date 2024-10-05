package com.seck.service;

import java.util.List;

import dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartemnt(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentById(Long departmentId);
	
	List<DepartmentDto> getAllDepartments();
	
	DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);
	
	void deleteDepartment(Long departmentId);
}
