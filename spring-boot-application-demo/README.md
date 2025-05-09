### Used below concepts

1. [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
2. [Spring Profiles](https://docs.spring.io/spring-boot/reference/features/profiles.html)
3. Specifications
	- [Spring Data JPA Specifications](https://docs.spring.io/spring-data/jpa/reference/jpa/specifications.html)
	- [The best way to use the Spring Data JPA Specification](https://vladmihalcea.com/spring-data-jpa-specification/)
	- [Getting Started with Spring Data Specifications](https://reflectoring.io/spring-data-specifications/)
4. Sort and Pagination
5. From `com.fasterxml.jackson`
	- ObjectMapper : `com.fasterxml.jackson.databind.ObjectMapper`
	- JavaTimeModule: `com.fasterxml.jackson.datatype.jsr310.JavaTimeModule`
	- JsonSerializer: `com.fasterxml.jackson.databind.JsonSerializer`
	- JsonDeserializer: `com.fasterxml.jackson.databind.JsonDeserializer`
6. Java Persistence API (JPA) for for managing persistence and object-relational mapping from `jakarta.persistence`
7. Constraint validations from `jakarta.validation`
8. `@RestControllerAdvice` and `@ExceptionHandler` for custom exception handler from Spring Framework
9. Oracle Database
10. REST Caching Techniques
	- [Caching REST API Response](https://restfulapi.net/caching/)
	- [Understanding and Implementing ETags in REST APIs](https://medium.com/@reetesh043/understanding-and-implementing-etags-in-rest-apis-659abe0f91ab)
11. [Spring Boot - Versioning a REST API](https://www.geeksforgeeks.org/spring-boot-versioning-a-rest-api/) - not used for now
12. [Spring Filters](https://docs.spring.io/spring-framework/reference/web/webmvc/filters.html)
	- [Add a Servlet, Filter, or Listener to an Application](https://docs.spring.io/spring-boot/how-to/webserver.html#howto.webserver.add-servlet-filter-listener)
	- [Using Filters in Spring Web Applications](https://springframework.guru/using-filters-in-spring-web-applications/)
	- [Spring Boot - Servlet Filter](https://www.geeksforgeeks.org/spring-boot-servlet-filter/)
13. How to modify request parameters using Servlet Filters
	- [Modify request parameters using a servlet filter](https://github.com/briefjudofox/servlet-filter-example/blob/master/README.md#modify-request-parameters-using-a-servlet-filter)
	- [Safely add / modify Servlet request parameter values](https://www.ocpsoft.org/opensource/how-to-safely-add-modify-servlet-request-parameter-values/)
	- [Set a Parameter in an HttpServletRequest in Java](https://www.baeldung.com/java-servlet-request-set-parameter)
14. [Spring Interceptors](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-config/interceptors.html)
	- [Introduction to Spring MVC HandlerInterceptor](https://www.baeldung.com/spring-mvc-handlerinterceptor)
	- [Spring Boot - Interceptor](https://www.geeksforgeeks.org/spring-boot-interceptor/)
	- [What is Spring Boot Request Interceptor and How to Use It?](https://medium.com/@aedemirsen/what-is-spring-boot-request-interceptor-and-how-to-use-it-7fd85f3df7f7)
	- [Unpacking Spring Interceptors](https://medium.com/@ahmed.abdelfaheem/unpacking-spring-interceptors-11808892ed08)
	- [Spring HandlerInterceptor Example](https://howtodoinjava.com/spring-mvc/spring-intercepting-requests-using-handlerinterceptor-with-example/)
15. Filters vs. Interceptors
	- [Spring MVC HandlerInterceptor vs. Filter](https://www.baeldung.com/spring-mvc-handlerinterceptor-vs-filter)
	- [Spring MVC - Servlet Filter vs Handler Interceptor](https://www.geeksforgeeks.org/spring-mvc-servlet-filter-vs-handler-interceptor/)
	- [Filter vs. Interceptor in Spring Boot](https://senoritadeveloper.medium.com/filter-vs-interceptor-in-spring-boot-2e49089f682e)
16. [Customizing the Banner](https://docs.spring.io/spring-boot/reference/features/spring-application.html#features.spring-application.banner)
	- You can use [Text ASCII Art Generator](https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20) to generate a custom banner. Copy the generated text and paste it in the banner.txt
	- [Using Custom Banners in Spring Boot](https://www.baeldung.com/spring-boot-custom-banners)
	- [How to Create Custom Banners in Spring Boot?](https://www.geeksforgeeks.org/custom-banners-in-spring-boot/)
17. [Spring RestTemplate](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-resttemplate)
	- [The Guide to RestTemplate](https://www.baeldung.com/rest-template)
	- [Spring – RestTemplate](https://www.geeksforgeeks.org/spring-resttemplate/)
	- [Understanding RestTemplate in Java Spring: When and How to Use It](https://medium.com/@psdevraye/understanding-resttemplate-in-java-spring-when-and-how-to-use-it-79500987a53c)
	- [Advantages and Disadvantages of RestTemplate in Java](https://medium.com/@psdevraye/advantages-and-disadvantages-of-resttemplate-in-java-f647a364f091)
	- [How to use basic authentication with RestTemplate](https://attacomsian.com/blog/resttemplate-basic-authentication)
18. Asynchronous Execution Support in Spring Boot using `@EnableAsync` and `@Async`
	- [How Does Spring Boot Implement Asynchronous Programming? This Is How Masters Do It!](https://medium.com/javarevisited/how-does-spring-boot-implement-asynchronous-programming-this-is-how-masters-do-it-e89fc9245928)
	- [SpringBoot @Async: The magic and the gotchas](https://medium.com/@dvikash1001/springboot-async-the-magic-and-the-gotchas-17f9471c6fe4)
	- [Spring Boot - @Async Annotation](https://www.geeksforgeeks.org/spring-boot-async-annotation/)
19. [Spring WebClient](https://docs.spring.io/spring-framework/reference/web/webflux-webclient.html)
	- [Spring WebClient - Baeldung](https://www.baeldung.com/spring-5-webclient)
	- [Spring WebFlux Tutorial with CRUD Example](https://howtodoinjava.com/spring-webflux/spring-webflux-tutorial/)
	- [Spring Boot Reactive Programming](https://javatechonline.com/spring-boot-tutorial/#Spring_Boot_Reactive_Programming)
	- [Mastering WebClient in Spring Boot: When and Why to Use It Over RestTemplate](https://medium.com/@psdevraye/mastering-webclient-in-spring-boot-when-and-why-to-use-it-over-resttemplate-03f0643421dc)
	- [Transitioning from RestTemplate to WebClient in Spring Boot: A Detailed Guide](https://medium.com/hprog99/transitioning-from-resttemplate-to-webclient-in-spring-boot-a-detailed-guide-4febd21063ba)
20. [Spring Boot - ApplicationRunner & CommandLineRunner](https://docs.spring.io/spring-boot/reference/features/spring-application.html#features.spring-application.command-line-runner)
	- [Spring Boot CommandLineRunner Example](https://mkyong.com/spring-boot/spring-boot-commandlinerunner-example/)
	- [Spring Boot - CommandLineRunner and ApplicationRunner](https://www.geeksforgeeks.org/spring-boot-commandlinerunner-and-applicationrunner/)
	- [Spring Boot Runners: CommandLine vs Application](https://javadzone.com/spring-boot-runners-commandline-vs-application/)
21. [Externalized Configuration](https://docs.spring.io/spring-boot/reference/features/external-config.html)
	* `@PropertySource`
	    * [Using `@PropertySource`](https://docs.spring.io/spring-framework/reference/core/beans/environment.html#beans-using-propertysource)
	    * [Accessing Properties in Spring Boot](https://howtodoinjava.com/spring-boot/properties-with-spring-boot/)
	    * [How to load custom properties files in Spring Boot](https://mkyong.com/spring-boot/how-to-load-custom-properties-files-in-spring-boot/)
	* `@ConfigurationProperties`
	    * [Type-safe Configuration Properties](https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config.typesafe-configuration-properties)
	    * [Guide to @ConfigurationProperties in Spring Boot](https://www.baeldung.com/configuration-properties-in-spring-boot)
22. Singleton Bean - Concurrent Requests
	- [How Does the Spring Singleton Bean Serve Concurrent Requests?](https://www.baeldung.com/spring-singleton-concurrent-requests)
	- [Spring Singleton Bean Behavior for Concurrent Requests.](https://medium.com/@sandaruwanims/spring-singleton-bean-behavior-for-concurrent-requests-2e90f1384eb0)
	- [3 Ways to tune Apache Tomcat in Spring Boot](https://medium.com/@dharampro/3-ways-to-tune-apache-tomcat-in-spring-boot-891691915cb2)
	- [Spring Boot Server Properties](https://docs.spring.io/spring-boot/appendix/application-properties/index.html#appendix.application-properties.server)
