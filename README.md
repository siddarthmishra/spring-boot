# Spring Boot

[Spring Initializr](http://start.spring.io/)

[Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-documentation)

[Starters](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter)

[Spring Boot Dev Tools](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools)

[Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)

~~~
mvn clean compile test

mvn package

mvn spring-boot:run
~~~

---

##### Running Spring Boot from command line
* Option 1 : Use java -jar
* Option 2 : Use Spring Boot Maven plugin
    * `mvnw spring-boot:run` or `mvn spring-boot:run`

---

[Spring Boot Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#common-application-properties)

[Spring Boot Logging](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging)

---

##### Various DAO Techniques
* Use EntityManager but leverage native Hibernate API
* Use EntityManager and standard JPA API
* Spring Data JPA

---

[JPA Query Language (JPQL)](https://docs.oracle.com/javaee/7/tutorial/persistence-querylanguage.htm#BNBTG)

[Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details)

[JpaRepository Docs](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)

[Spring Data REST](https://spring.io/projects/spring-data-rest)

[Spring Data REST Documentation](https://spring.io/projects/spring-data-rest#learn)

---

##### `@RepositoryRestResource(path = "members")`
> if we want to expose a different resource name?
> instead of "/employees" (or default) to use "/members" (customized)
> so path will be http://localhost:8080/members
	
##### Pagination
* Default page size is 20
* Pages are zero based
* To navigate page 
    * [http://localhost:8080/employees?page=0](http://localhost:8080/employees?page=0)
    * [http://localhost:8080/employees?page=1](http://localhost:8080/employees?page=1)
* Properties
    * spring.data.rest.default-page-size=50
    * spring.data.rest.max-page-size=

##### To make default base path
* spring.data.rest.base-path=/magic-api

> Here, http://localhost:8080/magic-api will be default base path
	
##### Sorting
In Employee,we have firstName, lastName and email
* [http://localhost:8080/employees/?sort=lastName](http://localhost:8080/employees/?sort=lastName)
* [http://localhost:8080/employees/?sort=firstName,desc](http://localhost:8080/employees/?sort=firstName,desc)
* [http://localhost:8080/employees/?sort=lastName,firstName,asc](http://localhost:8080/employees/?sort=lastName,firstName,asc)
* [http://localhost:8080/magic-api/employees?sort=firstName,desc&page=3](http://localhost:8080/magic-api/employees?sort=firstName,desc&page=3)

---

[Bootstrap](https://getbootstrap.com/)

[Thymeleaf](www.thymeleaf.org)

[Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
* [Form Creation](https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html#creating-a-form)

---
