package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL

	// Using JPA Named Queries
	// https://docs.spring.io/spring-data/jpa/docs/2.2.7.RELEASE/reference/html/#jpa.query-methods.named-queries
	@Query(value = "SELECT SYSDATE() FROM DUAL", nativeQuery = true)
	public String getSysdate();
	
	// Using Named Parameters
	// https://docs.spring.io/spring-data/jpa/docs/2.2.7.RELEASE/reference/html/#jpa.named-parameters
	@Query("select e from Employee e where e.firstName = :firstname or e.lastName = :lastname")
	Employee findByLastnameOrFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);

}
