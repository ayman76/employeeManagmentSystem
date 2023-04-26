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

	public Employee insert(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee update(Employee employee) {
		Employee updated = getById(employee.getId());
		updated.setFirstName(employee.getFirstName());
		updated.setLastName(employee.getLastName());
		updated.setEmail(employee.getEmail());
		return employeeRepo.save(updated);
	}

	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
	}
	
	
}
