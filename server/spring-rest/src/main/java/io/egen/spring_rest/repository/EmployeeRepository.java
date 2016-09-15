package io.egen.spring_rest.repository;

import java.util.List;

import io.egen.spring_rest.entity.Employee;

public interface EmployeeRepository {

	public List<Employee> findAll();

	public Employee findOne(String empId);

	public Employee findByEmail(String email);

	public Employee create(Employee emp);

	public Employee update(Employee emp);

	public void delete(Employee existing);
}
