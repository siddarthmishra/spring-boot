package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define fields for entityManager
	private EntityManager entityManager;

	// set up constructor(any) injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		// execute the query
		List<Employee> employees = query.getResultList();

		// return the result
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class, id);

		// https://stackoverflow.com/questions/1074081/hibernate-error-org-hibernate-nonuniqueobjectexception-a-different-object-with/1076376
		// above error while update (PutMapping)
		// this will remove the object from irst level (session) cache
		session.evict(employee);

		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {

		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("delete from Employee where id = : employeeId");
		query.setParameter("employeeId", id);

		query.executeUpdate();
	}

}
