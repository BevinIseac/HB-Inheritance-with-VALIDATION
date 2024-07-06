# HB-Inheritance-with-VALIDATION

## Overview

This project demonstrates the use of Hibernate for handling inheritance in a Java application, along with implementing various field validations. It showcases different inheritance strategies provided by Hibernate and the use of JSR 380 (Bean Validation 2.0) for ensuring data integrity.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Inheritance Strategies](#inheritance-strategies)
- [Validations](#validations)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Hibernate is a powerful ORM (Object-Relational Mapping) tool that simplifies the development of Java applications interacting with databases. This project illustrates how to map Java class hierarchies to database tables using different inheritance strategies provided by Hibernate, and how to apply validation constraints to entity fields.

## Technologies Used

- Java 17
- Hibernate 5.x
- JSR 380 (Bean Validation 2.0)
- H2 Database (in-memory)
- Maven

## Setup

1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/HB-Inheritance-with-VALIDATION.git
    cd HB-Inheritance-with-VALIDATION
    ```

2. **Build the project:**
    ```sh
    mvn clean install
    ```

3. **Run the application:**
    ```sh
    mvn exec:java
    ```

## Usage

The main class `Test` runs the application and demonstrates the inheritance strategies and validations. It prompts for user input, validates the input, and then saves valid data to the database.

### Example Usage

```java
public static void main(String[] args) {
    // Validation and saving logic here
}
```
### Inheritance Strategies
The project demonstrates the following Hibernate inheritance strategies:

Table Per Class
### Validations
Field validations are implemented using JSR 380 (Bean Validation 2.0). The following constraints are demonstrated:

### Person Validations:
```java
@Size(max = 20, min = 3, message = "Invalid name. Size should be between 3 and 20.")
@NotEmpty(message = "Please enter your name.")
private String name;

@Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters.")
@NotEmpty(message = "Please enter your address.")
private String address;

```
### Customer Validations:
```java

@Email(message = "Invalid email address. Please enter a proper email ID.")
@NotEmpty(message = "Please enter your email ID.")
private String email;

@Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits.")
@NotEmpty(message = "Please enter your mobile number.")
private String mobile;

@NotNull(message = "Please select a customer type.")
@Pattern(regexp = "Regular|VIP|Guest", message = "Customer type must be 'Regular', 'VIP', or 'Guest'.")
private String customerType;
```

### Employee Validations:
```java
@Positive(message = "Invalid Salary. Value should be positive.")
private float salary;

@Size(max = 20, min = 3, message = "Invalid destination. Size should be between 3 and 20.")
@NotEmpty(message = "Please enter your Destination.")
private String destination;

@Future(message = "Invalid date. It should be provided as a future date.")
private Date dtofjoining;

```
### Project Structure
The project structure includes the following key components:

Entities:

Person: Base entity class.
Customer: Subclass of Person with additional fields.
Employee: Subclass of Person with additional fields.
Hibernate Configuration:

hibernate.cfg.xml: Configuration file for Hibernate.
Utility:

HBUtil: Utility class for obtaining SessionFactory.
Main Class:

Test: Main class for running the application.


### Contributing
Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

Fork the repository
Create a new branch (git checkout -b feature/your-feature)
Commit your changes (git commit -am 'Add some feature')
Push to the branch (git push origin feature/your-feature)
Create a new Pull Request



### License
This project is licensed under the MIT License - see the LICENSE file for details.


This `README.md` file provides a comprehensive guide to your project, including setup instructions, descriptions of the inheritance strategies, validations, and the overall project structure. Adjust the content as necessary to fit the specifics of your project.






