

#### **1. What is Spring Boot?**
   - **Answer**: 
     Spring Boot is an open-source framework designed to simplify the setup and development of Spring applications. It provides production-ready features such as embedded servers, health checks, and externalized configuration. It allows developers to create stand-alone, production-grade Spring-based applications with minimal setup.

#### **2. What are the advantages of using Spring Boot?**
   - **Answer**:
     - **Simplified Configuration**: Spring Boot eliminates the need for extensive XML configurations and offers default configurations.
     - **Embedded Server**: It comes with embedded servers like Tomcat, Jetty, or Undertow, so you don’t need to deploy applications to an external server.
     - **Production-ready**: It offers features like health checks, metrics, and externalized configuration, making it production-ready.
     - **Auto Configuration**: Spring Boot automatically configures the application based on the libraries present on the classpath.

#### **3. What are the main features of Spring Boot?**
   - **Answer**:
     - **Auto Configuration**
     - **Standalone Applications**
     - **Production-ready Features** (e.g., health checks, metrics)
     - **Embedded Servers**
     - **Spring Boot Starter Projects**
     - **Spring Boot CLI** for rapid development

#### **4. What is the difference between Spring and Spring Boot?**
   - **Answer**:
     - **Spring**: A comprehensive framework that requires configuration and integration with external servers (e.g., Tomcat).
     - **Spring Boot**: A simplified version of Spring that provides embedded servers and auto-configuration to reduce setup time and boilerplate code.

#### **5. What are Spring Boot Starters?**
   - **Answer**:
     Spring Boot Starters are pre-configured sets of dependencies that help you get started with a specific feature or technology. For example, `spring-boot-starter-web` for building web applications, `spring-boot-starter-data-jpa` for JPA, etc.

#### **6. What is Spring Boot Actuator?**
   - **Answer**:
     Spring Boot Actuator provides built-in endpoints to monitor and manage your Spring Boot application in production. It includes endpoints like `/actuator/health`, `/actuator/metrics`, and `/actuator/env`.

#### **7. How do you configure Spring Boot properties?**
   - **Answer**:
     You can configure Spring Boot properties in several ways:
     - **application.properties** or **application.yml** (default location).
     - **Command-line arguments**.
     - **Environment variables**.
     - **JVM System Properties**.

#### **8. What is the role of the `@SpringBootApplication` annotation?**
   - **Answer**:
     The `@SpringBootApplication` annotation is a convenience annotation that combines three annotations:
     - `@Configuration`: Indicates that the class provides Spring configuration.
     - `@EnableAutoConfiguration`: Tells Spring Boot to automatically configure the application based on the dependencies in the classpath.
     - `@ComponentScan`: Enables component scanning to find and register beans in the Spring application context.

#### **9. What is the difference between `@Component`, `@Service`, `@Repository`, and `@Controller`?**
   - **Answer**:
     - **@Component**: A generic stereotype for any Spring-managed bean.
     - **@Service**: A specialization of `@Component` used for service-layer beans.
     - **@Repository**: A specialization of `@Component` used for DAO or data-access layer beans.
     - **@Controller**: A specialization of `@Component` used for Spring MVC controllers.

#### **10. What is the purpose of `@EnableAutoConfiguration` in Spring Boot?**
   - **Answer**:
     The `@EnableAutoConfiguration` annotation is used to automatically configure Spring application based on the dependencies present in the classpath. It helps in reducing the need for manual configuration and setting up the application.

#### **11. How do you create a Spring Boot RESTful Web Service?**
   - **Answer**:
     To create a RESTful Web Service in Spring Boot, you need to:
     1. Create a Spring Boot application.
     2. Use the `@RestController` annotation to create REST endpoints.
     3. Use the `@RequestMapping` or other HTTP-specific annotations like `@GetMapping`, `@PostMapping`, etc.
     4. Run the application and test it using tools like Postman or curl.

#### **12. What is `Spring Boot CLI`?**
   - **Answer**:
     Spring Boot CLI (Command Line Interface) is a command-line tool that allows you to quickly prototype Spring Boot applications. It supports Groovy-based scripts and simplifies the development process.

#### **13. How does Spring Boot handle exception handling?**
   - **Answer**:
     Spring Boot provides built-in support for exception handling using `@ControllerAdvice` or `@ExceptionHandler`. These can be used to handle exceptions globally or within specific controllers.

#### **14. How can you run a Spring Boot application?**
   - **Answer**:
     You can run a Spring Boot application in the following ways:
     - From the command line using `mvn spring-boot:run`.
     - By running the main method of the application class (annotated with `@SpringBootApplication`).
     - By packaging the application as a `.jar` file and running it using `java -jar`.

#### **15. What is Spring Boot's embedded Tomcat?**
   - **Answer**:
     Spring Boot includes embedded Tomcat as a default web server. This means that you don't need to deploy your application to an external Tomcat server. Spring Boot automatically configures Tomcat as an embedded server when the application is run.

#### **16. What is the purpose of `@RequestMapping` annotation in Spring Boot?**
   - **Answer**:
     The `@RequestMapping` annotation is used to map HTTP requests to handler methods of MVC and REST controllers. It can handle various HTTP methods like `GET`, `POST`, `PUT`, `DELETE`, etc.

#### **17. How can you manage database connections in Spring Boot?**
   - **Answer**:
     Spring Boot uses `Spring Data JPA` to simplify database interactions. You can configure database connections using `application.properties` or `application.yml`. Spring Boot will automatically configure the DataSource, JPA, and Hibernate settings based on the database configurations.

#### **18. What is the role of Spring Boot’s `application.properties` or `application.yml`?**
   - **Answer**:
     `application.properties` or `application.yml` are used to externalize configuration in a Spring Boot application. These files allow you to define properties such as server port, database connection settings, and other application-specific configurations.

#### **19. What is the difference between `@Value` and `@ConfigurationProperties` in Spring Boot?**
   - **Answer**:
     - `@Value`: Used to inject a property value into a Spring bean from the configuration file (`application.properties` or `application.yml`).
     - `@ConfigurationProperties`: Used to bind a group of related properties to a Spring bean in a more structured way, often used for complex configuration.

#### **20. What are Spring Boot’s "Starters"?**
   - **Answer**:
     Spring Boot Starters are a set of convenient dependency descriptors you can include in your application. Each starter provides a pre-configured set of dependencies for specific functionality, such as `spring-boot-starter-web` for web applications or `spring-boot-starter-data-jpa` for database applications.
