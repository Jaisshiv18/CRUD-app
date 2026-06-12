# Student Management REST API

A RESTful API built using Spring Boot and MongoDB for managing student records. The application provides CRUD operations to create, retrieve, update, and delete student information.

## Features

* Create a new student
* Get all students
* Get student by ID
* Update student details
* Delete student
* MongoDB database integration
* DTO-based request and response handling
* Layered architecture (Controller, Service, Repository)

## Tech Stack

* Java 24
* Spring Boot
* Spring Data MongoDB
* MongoDB Atlas
* Maven
* ModelMapper

## Project Structure

src/
├── Controller/
├── DTO/
├── Entity/
├── Repository/
├── Service/
└── config/

## API Endpoints

### Create Student

POST /students

### Get All Students

GET /students

### Get Student By ID

GET /students/{id}

### Update Student

PUT /students/{id}

### Delete Student

DELETE /students/{id}

## Running the Project

### Clone the repository

git clone <repository-url>

### Navigate to project directory

cd student-rest-api

### Configure MongoDB

Update application.properties with your MongoDB connection string.

### Run the application

./mvnw spring-boot:run

or

mvn spring-boot:run

The application will start on:

http://localhost:8080

## Future Improvements

* Spring Security with JWT Authentication
* Validation and Exception Handling
* Swagger/OpenAPI Documentation
* Pagination and Sorting
* Unit and Integration Testing

## Author

Shivanshu Jaiswal
