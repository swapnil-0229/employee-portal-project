# Employee Portal REST API

This is a demo project for Spring Boot that provides a RESTful API for a simple Employee Management System. It allows for full CRUD (Create, Read, Update, Delete) operations on employee data.

This project is built using modern versions of Spring Boot and Java, emphasizing clean code and standard development practices.

## Technologies Used

* **Java:** 21
* **Spring Boot:** 3.2.5
    * Spring Web: For building RESTful APIs.
    * Spring Data JPA: For database interaction with JPA and Hibernate.
    * Spring Boot Starter JDBC
    * Spring Validation: For data validation.
* **Database:** MySQL
    * `mysql-connector-j` version `8.3.0`
* **Build Tool:** Apache Maven
* **Utilities:**
    * Lombok: To reduce boilerplate code.

## Prerequisites

Before you begin, ensure you have the following installed on your system:

* **Java Development Kit (JDK) 21 or higher**
* **Apache Maven**
* **A running MySQL server instance**

## Setup and Installation

Follow these steps to get the application running locally.

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/swapnil-0229/employee-portal-project.git](https://github.com/swapnil-0229/employee-portal-project.git)
    cd employee-portal-project
    ```

2.  **Create the MySQL Database:**
    Log in to your MySQL client and run the following command to create the necessary database:
    ```sql
    CREATE DATABASE learning;
    ```

3.  **Configure the Database Connection:**
    Open the `src/main/resources/application.properties` file. Update the `spring.datasource.username` and `spring.datasource.password` properties to match your local MySQL credentials.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/learning
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

4.  **Build and Run the Application:**
    You can build and run the application using the Spring Boot Maven plugin.
    ```bash
    mvn spring-boot:run
    ```
    The application will start and be accessible at `http://localhost:8080`.

## API Endpoints

The API provides the following endpoints for managing employees:

| Method | URL                  | Description                          |
|--------|----------------------|--------------------------------------|
| `GET`  | `/allemp`            | Retrieves a list of all employees.   |
| `GET`  | `/emp/{empId}`       | Retrieves a single employee by ID.   |
| `POST` | `/emp`               | Creates a new employee.              |
| `PUT`  | `/emp`               | Updates an existing employee.        |
| `DELETE`| `/emp/{empId}`      | Deletes an employee by ID.           |