package com.seck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seck.service.DepartmentService;

import dto.DepartmentDto;

@RestController
@RequestMapping("api/departments")
@CrossOrigin("http://localhost:3000")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto department = departmentService.createDepartemnt(departmentDto);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
		
		DepartmentDto department = departmentService.getDepartmentById(departmentId);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
		List<DepartmentDto> departments =  departmentService.getAllDepartments();
		
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, 
														@RequestBody DepartmentDto updatedDepartment){
		
		DepartmentDto department = departmentService.updateDepartment(departmentId, updatedDepartment);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
		
		departmentService.deleteDepartment(departmentId);
		return new ResponseEntity<String>("Department deleted successfully! ", HttpStatus.OK);
	}
}
