# GomoSpringBoot CRUD Application
## Technical Documentation

### Connect with Me 🔗
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)]([https://linkedin.com/in/your-profile](https://www.linkedin.com/in/moneshgomo/))
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/MONESHGOMO/MONESHGOMO)
[![Website](https://img.shields.io/badge/Website-000000?style=for-the-badge&logo=google-chrome&logoColor=white)](https://moneshgomo.netlify.app/)

### 1. System Architecture

#### 1.1 Technology Stack
- Java 23
- Spring Boot 3.3.5
- MySQL
- Maven
- Spring Web
- Spring Data JPA
- Lombok
- MySQL Driver

#### 1.2 Architecture Layers
```
└── Application Layer
    ├── Controller Layer (REST endpoints)
    ├── Service Layer (Business logic)
    ├── Repository Layer (Data access)
    └── Model Layer (Entity definitions)
```

### 2. Database Configuration

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 3. API Endpoints

#### GET /api/students
- Retrieves all students
- Response: Array of student objects

#### GET /api/students/{id}
- Retrieves specific student
- Parameter: id (Long)

#### POST /api/students
- Creates new student
- Request Body: Student object (without id)
```json
{
    "name": "John Doe",
    "age": 22,
    "email": "john.doe@example.com"
}
```

#### PUT /api/students/{id}
- Updates existing student
- Parameter: id (Long)
- Request Body: Updated student data

#### DELETE /api/students/{id}
- Removes student record
- Parameter: id (Long)

### 4. Data Model

Student Entity:
```json
{
    "id": "Long",
    "name": "String",
    "age": "Integer",
    "email": "String"
}
```

### 5. Development Setup

#### Requirements
- JDK 23
- MySQL Server
- Maven 3.x
- IDE

#### Application Properties
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 6. Build and Run

```bash
# Build
mvn clean install

# Run
java -jar target/Gomo-0.0.1-SNAPSHOT.jar
```

### 7. API Testing

Test endpoints using:
- Postman
- Web Browsers (GET requests)

Sample Data:
```json
{
    "name": "Rajesh Kumar",
    "age": 21,
    "email": "rajesh.kumar@gmail.com"
}
```

---
📫 Feel free to reach out for any questions or collaborations!

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/your-profile)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/your-profile)
[![Website](https://img.shields.io/badge/Website-000000?style=for-the-badge&logo=google-chrome&logoColor=white)](https://moneshgomo.netlify.app/)
