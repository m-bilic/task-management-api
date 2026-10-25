# Task Management API

A REST API for managing tasks, projects and users, built with Spring Boot.

This is a learning exercise. I wrote all of the code by hand, built it up step by step
and looked up the Spring annotations and concepts in the official documentation and guides
as I went.

## Running it

    ./mvnw spring-boot:run

The API runs on http://localhost:8080, and the H2 console is at /h2-console.

## Endpoints

| Method | Path        | Description         |
|--------|-------------|---------------------|
| GET    | /tasks      | List all tasks      |
| GET    | /tasks/{id} | Get one task        |
| POST   | /tasks      | Create a task       |
| PUT    | /tasks/{id} | Update a task       |
| DELETE | /tasks/{id} | Delete a task       |
