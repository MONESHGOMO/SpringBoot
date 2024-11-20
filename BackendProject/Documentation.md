
# GomoSpringBoot - CRUD Operations 😊 Beginner Friendly 


## Overview
**GomoSpringBoot** is a Spring Boot application that implements basic CRUD operations for managing student details like name, age, and email. This project is designed to enhance my backend development skills using Java, Spring Boot, and MySQL. It demonstrates how to interact with databases and manage data through RESTful APIs.

## ⚙️ Technologies Used
- **Java 23**: Programming language used for the backend development.
- **Spring Boot 3.3.5**: Framework used to simplify the development of the backend application.
- **MySQL**: Relational database management system for storing student data.
- **Maven**: Build automation tool used to manage dependencies and build the application.
- **Lombok**: A library that reduces boilerplate code by generating getters, setters, and constructors at compile time.
- **Spring Web**: Provides support for building RESTful web services.
- **Spring Data JPA**: Simplifies database interaction by using JPA (Java Persistence API) to interact with MySQL.
- **MySQL Driver**: Dependency used to connect the Spring Boot application with the MySQL database.
- **JAR File**: The final executable output after building the project.

## Prerequisites
Before you begin, ensure you have the following installed:
- **JDK 23**
- **IDE**: Eclipse, IntelliJ, or Visual Studio Code (any of your choice).
- **MySQL**: Install MySQL and create a database named `student`.

## 🖥️ Installation and Setup
1. **Clone or Download the Project**:
   - You can download the project as a `.zip` file or clone it from the repository.

2. **Run the Application**:
   - 🛑 If you are not using Catalyst, delete the `ServerPortCustomizer` class located in `src/main/java`.
   - Make sure your JDK 23 is installed and your IDE is ready.
   - Open the project in your IDE.

3. **Database Setup**:
   - Create a MySQL database called `student`.
   - Configure the `application.properties` file with your MySQL connection details, such as:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/student
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

4. **Check Port Number**:
   - Ensure that the server is set to port `8080`. You can modify the port in the `application.properties` file:
     ```properties
     server.port=8080
     ```

5. **Build the Application**:
   - In the terminal, navigate to your project directory and run the following Maven command:
     ```bash
     mvn clean install
     ```

6. **Run the Application**:
   - Start the Spring Boot application with the following command:
     ```bash
     java -jar target/Gomo-0.0.1-SNAPSHOT.jar
     ```

7. **Verify**:
   - Open a browser or Postman and access the following endpoints:
     - **Get All Students**: `http://localhost:8080/api/students`
     - **Get Student by ID**: `http://localhost:8080/api/students/{id}`
     - **Add New Student**: `POST http://localhost:8080/api/students`
     - **Update Student**: `PUT http://localhost:8080/api/students/{id}`
     - **Delete Student**: `DELETE http://localhost:8080/api/students/{id}`

## API Endpoints
### 1. **GET** `/api/students`
- **Description**: Retrieves all students from the database.
- **Response**:
  ```json
  [
    {
      "id": 1,
      "name": "Rajesh Kumar",
      "age": 21,
      "email": "rajesh.kumar@gmail.com"
    },
    {
      "id": 2,
      "name": "Priya Devi",
      "age": 22,
      "email": "priya.devi@yahoo.com"
    }
  ]
  ```

### 2. **GET** `/api/students/{id}`
- **Description**: Retrieves the details of a specific student using their id.
- **Response**:
  ```json
  {
    "id": 1,
    "name": "Rajesh Kumar",
    "age": 21,
    "email": "rajesh.kumar@gmail.com"
  }
  ```

### 3. **POST** `/api/students`
- **Description**: Adds a new student to the database. Note: Do not send the id in the request body as it will be auto-generated.
- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "age": 22,
    "email": "john.doe@example.com"
  }
  ```
- **Response**:
  ```json
  {
    "id": 3,
    "name": "John Doe",
    "age": 22,
    "email": "john.doe@example.com"
  }
  ```

### 4. **PUT** `/api/students/{id}`
- **Description**: Updates the details of an existing student using their id.
- **Request Body**:
  ```json
  {
    "name": "Jane Doe",
    "age": 23,
    "email": "jane.doe@example.com"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "name": "Jane Doe",
    "age": 23,
    "email": "jane.doe@example.com"
  }
  ```

### 5. **DELETE** `/api/students/{id}`
- **Description**: Deletes a student record using their id.
- **Response**:
  ```json
  {
    "message": "Student record deleted successfully."
  }
  ```

## Tools for Testing
- **Web Browsers**: Chrome, Firefox, Edge, etc.
- **API Testing Tools**: Postman or any other similar tool.

## Sample Data 
Here are some sample data entries for your application:

- **Student 1**:
  - Name: Rajesh Kumar
  - Age: 21
  - Email: rajesh.kumar@gmail.com

- **Student 2**:
  - Name: Priya Devi
  - Age: 22
  - Email: priya.devi@yahoo.com

- **Student 3**:
  - Name: Arun Ravi
  - Age: 20
  - Email: arun.ravi@hotmail.com

- **Student 4**:
  - Name: Meena Rani
  - Age: 23
  - Email: meena.rani@outlook.com

## Feel free to ak any doute ( Lets Grow Together ):

- [LinkedIn](https://www.linkedin.com/in/moneshgomo/)
- [GitHub](https://github.com/MONESHGOMO/MONESHGOMO)
- [Gomo🌐](https://gomoprogrammer.netlify.app/)


## Conclusion
This project is a basic implementation of CRUD operations using Spring Boot, MySQL, and Maven. It serves as a starting point for backend development and aims to improve your skills in creating RESTful APIs, working with databases, and using modern Java technologies. By completing this project, you’ve learned the essentials of building a backend API, working with a database, and performing CRUD operations.




