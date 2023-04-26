package com.global.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.ems.entity.Employee;
import com.global.ems.repository.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepo employeeRepo;
	

	public Employee findById(Long id) {
		return employeeRepo.findById(id).orElseThrow();
	}

	public Employee getById(Long id) {
		return employeeRepo.getReferenceById(id);
	}

	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	public Long count() {
		return employeeRepo.count();
	}

	public Employee insert(Employee student) {
		return employeeRepo.save(student);
	}

	public Employee update(Employee student) {
		Employee updated = getById(student.getId());
		updated.setFirstName(student.getFirstName());
		updated.setLastName(student.getLastName());
		updated.setEmail(student.getEmail());
		return employeeRepo.save(updated);
	}

	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
	}
	
	
}
