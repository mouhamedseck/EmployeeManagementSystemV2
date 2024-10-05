package com.seck.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seck.entity.Department;
import com.seck.exception.ResourceNotFoundException;
import com.seck.repository.DepartmentRepository;
import com.seck.service.DepartmentService;

import dto.DepartmentDto;
import mapper.DepartmentMapper;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto createDepartemnt(DepartmentDto departmentDto) {
		
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		Department departmentSaved = departmentRepository.save(department);
		
		return DepartmentMapper.mapToDepartmentDto(departmentSaved);
	}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
		
		Department department = departmentRepository.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department is not exists with a given id: "+departmentId)
				);
		
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		
		List<Department> departments = departmentRepository.findAll();
		return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
		
		Department department = departmentRepository.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department is not exists with a given id: "+departmentId)
				);
		department.setDepartmentName(updatedDepartment.getDepartmentName());
		department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
		
		Department saveDepartment = departmentRepository.save(department);
		
		return DepartmentMapper.mapToDepartmentDto(saveDepartment);
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		
		Department department = departmentRepository.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department is not exists with a given id: "+departmentId)
				);
		
		departmentRepository.deleteById(department.getId());
	}

}
