package io.egen.spring_rest.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.spring_rest.entity.Employee;
import io.egen.spring_rest.exception.EntityAlreadyExistException; 
import io.egen.spring_rest.exception.EntityNotFoundException;
import io.egen.spring_rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findOne(String empId) {
		Employee emp = repository.findOne(empId);
		if (emp == null) {
			throw new EntityNotFoundException("Employee not found");
		}
		return emp;
	}

	@Transactional
	@Override
	public Employee create(Employee emp) {
		Employee existing = repository.findByEmail(emp.getEmail());
		if (existing != null) {
			throw new EntityAlreadyExistException("Employee already exists with this email");
		}
		return repository.create(emp);
	}

	@Transactional
	@Override
	public Employee update(String empId, Employee emp) {
		Employee existing = repository.findOne(empId);
		if (existing == null) {
			throw new EntityNotFoundException("Employee not found");
		}
		return repository.update(emp);
	}

	@Transactional
	@Override
	public void remove(String empId) {
		Employee existing = repository.findOne(empId);
		if (existing == null) {
			throw new EntityNotFoundException("Employee not found");
		}
		repository.delete(existing);
	}
}