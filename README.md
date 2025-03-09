# Quiz Management System

## Overview
The **Quiz Management System** is a web-based application built with **Spring Boot** that allows students, teachers, and administrators to manage quizzes efficiently. It includes role-based authentication and authorization, JWT security, and API documentation using Swagger.

## Features
- **User Roles:** Admin, Teacher, Student  
- **Authentication & Authorization:** JWT-based security  
- **Quiz Management:** Create, update, and delete quizzes  
- **Question Bank:** Store and manage multiple-choice questions  
- **Student Participation:** Students can take quizzes and view results  
- **Reporting:** View quiz scores and analytics  
- **Swagger API Documentation:** Easily explore APIs  

## Technologies Used
- **Backend:** Java, Spring Boot 3.4.3, Spring Security, JWT Authentication  
- **Database:** MySQL  
- **API Documentation:** Springdoc OpenAPI (Swagger UI)  
- **Build Tool:** Maven

 ## Workflow Diagram
Below is a high-level workflow diagram of the **Quiz Management System**:

![Workflow Diagram](https://github.com/iammahesh123/quiz-exam-system/blob/main/quiz_diagram.png)

## ER Diagram
Below is a ER diagram of the **Quiz Management System**:

![ER Diagram](https://github.com/iammahesh123/quiz-exam-system/blob/main/quiz_er_diagram.png)

## Prerequisites
Ensure you have the following installed:  
- Java 17+  
- Maven 3+  
- MySQL Server  

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/iammahesh123/quiz-exam-system.git
cd quiz-exam-system
```

### 2. Configure Database
Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 4. Access the Application
- **API Documentation (Swagger UI):** `http://localhost:8080/swagger-ui.html`
- **API Endpoints:** `http://localhost:8080/v3/api-docs`

## Security Configuration
- **Public Endpoints:**
  - `POST /auth/login` (User Login)
  - `POST /auth/register` (User Registration)
  - Swagger UI (`/swagger-ui/**`, `/v3/api-docs/**`)
- **Role-Based Access:**
  - `ADMIN`: `/admin/**`
  - `TEACHER`: `/teacher/**`
  - `STUDENT`: `/student/**`

## License
This project is open-source and available under the [MIT License](LICENSE).

## Contributors
- **Mahesh Kadambala** - [GitHub Profile](https://github.com/iammahesh123)

---
Feel free to modify this file as needed to fit your project structure! 🚀
```

