# 📌 CRUD API Documentation


- 🛠️ Tools Required

## 1️⃣ Database: MySQL
- Install **MySQL** as the database for this project.
- Download from: [Youtube Video to download MySQL ](https://youtu.be/gsvYvufx1e0?si=Q_WrSOJRAybZBtfp)

# 2️⃣ API Testing: Postman
- Install **Postman** extension in **VS Code**:
  1. Open **VS Code**.
  2. Go to the **Extensions** tab (`Ctrl + Shift + X`).
  3. Search for **Postman**.
  4. Click **Install**.

# 3️⃣ Spring Boot & Java
- Ensure **Java JDK 17+** is installed.
---

🚀 Now you're ready to build & test your API! 🎯


- now go to you application

inside : src->main->java-> resources -> application.properties 

``` java

spring.datasource.url=jdbc:mysql://localhost:3306/ ( your database name  ) 
spring.datasource.username=root
spring.datasource.password= your database password 

```

after configuration done run the application and first go to google hit this URL ( API ) in search bar 

```API
http://localhost:8080/api/users

```


## 📌 Base URL
```
http://localhost:8080/api
```

## 📝 1️⃣ Add a New User (POST)

- **Endpoint:** `http://localhost:8080/api/postdata`
- **Method:** `POST`
- **Description:** Add a new user.
- **Request Body:**

```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "contact": 987654321
}
```

- **Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@example.com",
  "contact": 987654321
}
```

---
## 📝 2️⃣ Get All Users (GET)

- **Endpoint:** `http://localhost:8080/api/users`
- **Method:** `GET`
- **Description:** Retrieve all users.
- **Response:**

```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com",
    "contact": 987654321
  }
]
```

---
## 📝 3️⃣ Get User by ID (GET)

- **Endpoint:** `http://localhost:8080/api/users/{id}`
- **Method:** `GET`
- **Description:** Retrieve a user by ID.
- **Example:** `http://localhost:8080/api/users/1`
- **Response:**

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@example.com",
  "contact": 987654321
}
```

---
## 📝 4️⃣ Update User (PUT)

- **Endpoint:** `http://localhost:8080/api/users/{id}`
- **Method:** `PUT`
- **Description:** Update a user's information.
- **Example:** `http://localhost:8080/api/users/1`
- **Request Body:**

```json
{
  "name": "Gomo",
  "email": "johndoe@example.com",
  "contact": 987654321
}
```

- **Response:**

```json
{
  "id": 1,
  "name": "Gomo",
  "email": "johndoe@example.com",
  "contact": 987654321
}
```

---
## 📝 5️⃣ Add Another User (POST)

- **Endpoint:** `http://localhost:8080/api/postdata`
- **Method:** `POST`
- **Description:** Add another user.
- **Request Body:**

```json
{
  "name": "Hari",
  "email": "hari@example.com",
  "contact": 887554321
}
```

- **Response:**

```json
{
  "id": 2,
  "name": "Hari",
  "email": "hari@example.com",
  "contact": 887554321
}
```

---
## 📝 6️⃣ Get All Users After Adding Another User (GET)

- **Endpoint:** `http://localhost:8080/api/users`
- **Method:** `GET`
- **Description:** Retrieve all users after adding a new one.
- **Response:**

```json
[
  {
    "id": 1,
    "name": "Gomo",
    "email": "johndoe@example.com",
    "contact": 987654321
  },
  {
    "id": 2,
    "name": "Hari",
    "email": "hari@example.com",
    "contact": 887554321
  }
]
```

---
## 📝 7️⃣ Delete a User (DELETE)

- **Endpoint:** `http://localhost:8080/api/users/{id}`
- **Method:** `DELETE`
- **Description:** Delete a user by ID.
- **Example:** `http://localhost:8080/api/users/1`
- **Response:**

```
User deleted with id: 1
```

---
### 📢 Notes:
✔ Replace `{id}` with the actual user ID in API requests.
✔ Ensure the server is running before making API calls.
✔ Use a tool like **Postman** to test API requests.
✔ The `id` is **auto-generated** when a user is added.

