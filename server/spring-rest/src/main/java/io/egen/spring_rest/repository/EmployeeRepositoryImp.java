package io.egen.spring_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.spring_rest.entity.Employee;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findOne(String empId) {
		return em.find(Employee.class, empId);
	}

	@Override
	public Employee findByEmail(String email) {
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmail", Employee.class);
		query.setParameter("pEmail", email);
		List<Employee> employees = query.getResultList();
		if (employees.size() == 1) {
			return employees.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Employee create(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public Employee update(Employee emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Employee existing) {
		em.remove(existing);
	}
}