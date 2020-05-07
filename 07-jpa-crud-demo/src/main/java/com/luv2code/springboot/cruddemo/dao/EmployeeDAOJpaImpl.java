package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		Query query = entityManager.createQuery("from Employee");

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		// return result
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Employee employee = entityManager.find(Employee.class, id);

		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		// save or update the employee
		Employee dbEmployee = entityManager.merge(employee);

		// update with id from db. So we can get generated id for save/insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {

		// create query
		Query query = entityManager.createQuery("delete from Employee where id = :employeeId");
		query.setParameter("employeeId", id);

		query.executeUpdate();
	}

}
