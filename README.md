### Homework 5: Spring Data ###

Required:
- Get well acquainted with all topics mentioned in the lecture (especially with JPA and Spring Data JPA)
- Integrate your application with any relational database. You are free of choice regarding the relational database
management system to be used.
- integrate using Spring Data JPA (configure connection details, implement JPA repositories, etc.)
- add JPA entity mapping including mappings between entities (@OneToOne, @ManyToOne, etc.)
- make sure to use all/any of listed annotation: @Query, @NamedQuery, and @NamedNativeQuery.
- make sure to use ‘pageable’ and ‘sortable’ reads from the database.

Optional (would be a great plus):
- Make use of JdbcTemplate class somewhere in you code.
- Add transactions in your code using declarative or programmatic approach.
- Get well familiar with the @Transactional annotation (how it works under the hood, what CGlib & JDK Proxies are,
physical vs logical transactions etc.). Sources:
- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/index.html#transactions
- https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth

### Homework 4 ###

Required:

Extend your service functionality by:

- adding basic validation to DTO classes
- using mapstruct to map DTOs
- implementing custom common and unified error handling functionality using Spring MVC components
- adding the Spring Boot Actuator to your project and configuring the ‘/info’ endpoint of it.
- extending your service RESTful endpoints by Swagger Documentation
- create custom validation annotations using ConstraintValidator

Optional (would be a great plus):

- Investigate and get hands-on experience working with the RestTemplate: create a separate service that will make REST
  calls to your main service endpoints (GET, POST, PUT, PATCH, DELETE) and parse the response.
- Investigate add multilingual support for exception messages configuring the ‘MessageSource’ bean
  https://www.baeldung.com/spring-custom-validation-message-source

### Homework 3 ###

Required:

Migrate functionality related to core business logic of Servlet-based application to newly created Spring MVC project
adapting the old one to the correct package structure, naming conventions, etc.:

- get rid of all JSP views (now your service will be consuming and populating only JSON text format)
- make your service RESTful (don't implement HATEOAS logic for now. It will be accomplished in the scope of next
  lecture)
- the best approach is to start from the scratch and create an empty Spring Boot project using the 'Spring Initializr'.
- avoid code copypaste from the old project, unless it relates to the business logic.
- Create DTO classes and use them at the controller level.
- Add logging to all layers of the application.

Optional (would be a great plus):

1. Use any of available open source mapping tool in order to remap from business classes to DTO and vice versa (
   BeanUtils, MapStruct, etc.) 
