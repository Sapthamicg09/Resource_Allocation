# Resource Allocation Microservice

This is a simple resource allocation microservice built with Spring Boot. The application provides RESTful APIs to fetch a list of resources based on required skills and experience, tailored for different types of projects such as microservices and cloud projects.

## Project Overview

The project simulates a resource allocation system for IT projects. It allows you to:

- Retrieve a list of resources for a **Microservice Project** based on specific skills.
- Retrieve a list of resources for a **Cloud Project** based on required skills and a maximum experience limit.

The application uses Spring Boot, Spring Data JPA, and MySQL for database interaction.

## Features

- **Resource Entity**: A resource has a name, experience, and skillset.
- **Controller**: Exposes two endpoints:
  - `/api/resources/microservice`: Fetch resources based on required skills for a microservice project.
  - `/api/resources/cloud`: Fetch resources based on skills and experience for a cloud project.
- **Service Layer**: Contains business logic for matching resources with project requirements.
- **Exception Handling**: Global exception handling for internal and bad request errors.
- **Unit Tests**: Unit tests for the service layer using JUnit and Mockito.

## Technologies Used

- **Java 17**
- **Spring Boot 3.4.1**
- **Spring Data JPA**
- **MySQL**
- **Mockito for Unit Testing**
- **SLF4J Logger**

## Prerequisites

- Java 17 or above
- MySQL database
- Maven

## Setup

1. **Clone the repository:**

```bash
git clone https://github.com/yourusername/resource-allocation.git
cd resource-allocation


2. **Setup MySQL Database:**

Create a MySQL database and configure the connection details in the application.properties file.

spring.datasource.url=jdbc:mysql://localhost:3306/resource_db
spring.datasource.username=root
spring.datasource.password=root


3. **Build and run the application:**

Using Maven:

mvn spring-boot:run


4. **Access the API:**

Microservice project: GET /api/resources/microservice?skills=<skills>
Cloud project: GET /api/resources/cloud?skills=<skills>&maxExperience=<maxExperience>

Example:

For microservice project: GET /api/resources/microservice?skills=Java,Redis,Javascript
For cloud project: GET /api/resources/cloud?skills=Mysql,Docker,Spring,React&maxExperience=10



**UNIT TEST**

The application includes unit tests to validate the business logic in the ResourceServiceImpl.

You can run the tests using:

mvn test


