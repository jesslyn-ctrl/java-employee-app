# java-employee-app 
[![My Skills](https://skillicons.dev/icons?i=java,spring,maven,postgres,postman&theme=light)](https://skillicons.dev)

## Tech Stack (Backend Development & Testing)
- __Java__
- __Spring Boot__
- __Spring Data JPA__
- __Maven__
- __PostgreSQL__
- __REST API__
- __Spring Test__
- __JUnit__

## Getting Started

### Prerequisites

Please make sure you have the following software installed on your machine:

- **[Java Development Kit (JDK) 17](https://www.oracle.com/id/java/technologies/downloads/#java17)**
- **[Maven 3](https://maven.apache.org)**
- **[Eclipse IDE (min: 2021-09) ](https://www.eclipse.org/downloads/) | [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)**

### Steps

1. Clone the repository: `git clone <repository_url>`
2. Import the project into Eclipse:
   - Open Eclipse IDE.
   - Go to `File` -> `Import`.
   - Select `Existing Projects into Workspace` and click `Next`.
   - Choose the root directory of the cloned repository and click `Finish`.
3. Build the project:
   - Right-click on the project in the Eclipse Project Explorer.
   - Select `Run As` -> `Maven Build`.
   - In the `Goals` field, enter `clean install` and click `Run`.
   - Maven will build the project and download any required dependencies.
4. Run the application:
   - Right-click on the project in the Eclipse Project Explorer.
   - Select `Run As` -> `Spring Boot App`.
   - The application will start, and you can access it using the provided URL or API endpoints.


## Application Architecture

This application follows the MVC design pattern along with the Service and Repository layers. It aims to separate concerns and provide a structured approach to building scalable and maintainable applications.

### Layers Overview

1. **Controllers**:
   - Location: `app.controllers`
   - Responsible for handling incoming requests, processing data, and producing appropriate responses.
   - Interacts with the Services layer to fetch or manipulate data.
   - Implements the application's API endpoints.
   - Utilizes Data Transfer Objects (DTOs) for request and response payload handling.

2. **Models**:
   - Location: `app.models`
   - Represents the application's data entities or domain objects.
   - Contains the properties and behaviors of the objects used within the application.
   - Can include validation rules, business logic, and relationships with other entities.
   - Typically used by the Services and Repository layers to perform data operations.

3. **Services**:
   - Location: `app.services`
   - Implements the business logic and acts as an intermediary between Controllers and Repositories.
   - Provides operations and services that are specific to the application's requirements.
   - Orchestrates the flow of data and performs any necessary transformations or validations.
   - Utilizes the Repository layer for data access and manipulation.

4. **Repositories**:
   - Location: `app.repositories`
   - Responsible for data access and manipulation operations.
   - Provides an abstraction layer on top of the database or data storage mechanism.
   - Performs CRUD (Create, Read, Update, Delete) operations on the data entities.
   - Encapsulates the underlying data storage details, allowing for easy swapping of data sources if needed.

5. **DTOs**:
   - Location: `app.dtos`
   - Contains Data Transfer Objects used for communication between the Controllers and the external world.
   - Consists of Request DTOs that define the structure of incoming request payloads.
   - Consists of Response DTOs that define the structure of outgoing response payloads.

6. **Mappers**:
   - Location: `app.mappers`
   - Responsible for converting between Model objects and DTOs.
   - Helps in mapping the properties of the objects between different layers.
   - Allows separation of concerns and decouples the internal structure of objects from their external representation.

### Benefits of the Design Pattern

- **Separation of Concerns**: The MVC pattern separates the application's concerns into different layers, promoting code organization and maintainability.

- **Modularity and Reusability**: Each layer has a specific responsibility, making it easier to understand, modify, and reuse code.

- **Scalability**: The application can scale by adding more Controllers, Services, and Repositories as required without affecting other layers.

- **Testability**: The design pattern facilitates unit testing, as each layer can be tested independently with appropriate mocks and assertions.

- **Code Maintainability**: The separation of concerns and modular structure make it easier to identify and fix issues, add new features, and refactor code.


## API Documentation

- **Postman Documenter**: https://documenter.getpostman.com/view/10754308/2s93z6diiT
- **Swagger-UI**: Use this endpoint _/api/swagger-ui-custom.html_
- **Docs**: Use this endpoint _/api/docs_


## Reference

- **[Java Spring Boot](https://www.baeldung.com/spring-boot)**
- **[Spring JPA](https://spring.io/projects/spring-data-jpa)**
- **[Spring Boot with Hibernate JPA](https://www.baeldung.com/spring-boot-hibernate)**
- **[Maven](https://maven.apache.org/)**
- **[Open API 3 - Spring Boot](https://www.baeldung.com/spring-rest-openapi-documentation)**
- **[MVC Architecture in Java](https://www.javatpoint.com/mvc-architecture-in-java)**
