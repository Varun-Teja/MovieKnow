package io.egen.spring_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.spring_rest.entity.Employee;
import io.egen.spring_rest.service.EmployeeService;

@RestController
@RequestMapping(value = "employees", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Employee findOne(@PathVariable("id") String empId) {
		return service.findOne(empId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee create(@RequestBody Employee emp) {
		return service.create(emp);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee update(@PathVariable("id") String empId, @RequestBody Employee emp) {
		return service.update(empId, emp);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String empId) {
		service.remove(empId);
	}
}