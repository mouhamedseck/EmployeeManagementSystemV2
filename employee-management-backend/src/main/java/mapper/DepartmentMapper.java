package mapper;

import com.seck.entity.Department;

import dto.DepartmentDto;

public class DepartmentMapper {

	public static DepartmentDto mapToDepartmentDto (Department department) {
	
		return new DepartmentDto(
				
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription()
				);
	}
	
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		
		return new Department(
				
			departmentDto.getId(),
			departmentDto.getDepartmentName(),
			departmentDto.getDepartmentDescription()
				);
	}
}
	
