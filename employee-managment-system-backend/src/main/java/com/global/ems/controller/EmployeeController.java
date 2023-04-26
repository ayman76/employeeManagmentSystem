package com.global.ems.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.ems.entity.Employee;
import com.global.ems.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}

	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(employeeService.findAll());
	}

	@GetMapping("/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok(employeeService.count());
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.insert(employee));
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.update(employee));
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		employeeService.deleteById(id);
	}

}
