College Admission Management System
📘 Description

The College Admission Management System is a simple Java-based project that helps manage students, courses, and admission applications using a MySQL database.
It allows you to:

Add and view students

Add and view courses

Submit admission applications

Automatically approve or reject applications based on student marks and course cut-off

This project is built using Core Java and JDBC (Java Database Connectivity) for handling MySQL database operations.
It’s designed to help beginners understand how to connect Java applications to a database and perform basic CRUD (Create, Read, Update, Delete) operations.

🧩 Features

Add new students with their marks

Add courses with their cutoff marks

Apply for a course

Approve or reject applications based on eligibility

View all students, courses, and applications from the database

🗂️ Project Structure
CollegeAdmissionManagement/
│
├── Database.java          → Handles MySQL connection
├── Student.java           → Student data model
├── Course.java            → Course data model
├── Application.java       → Application data model
├── Admission.java         → Handles all database operations
└── Main.java              → Runs the project

🧠 Database Details

Database Name: admissionmanagement

Tables used:

student:

student_id (INT, Primary Key)

student_name (VARCHAR)

email (VARCHAR)

marks (FLOAT)

courses:

course_id (INT, Primary Key)

course_name (VARCHAR)

cutoff (FLOAT)

applications:

app_id (INT, Primary Key)

student_id (INT, Foreign Key)

course_id (INT, Foreign Key)

app_status (VARCHAR)

⚙️ Technologies Used

Java (JDK 8 or above)

MySQL

JDBC

IDE: Eclipse / IntelliJ / VS Code
 
How to Run

Install MySQL and create a database named admissionmanagement.

Create the required tables using the SQL commands from the project.

Update your MySQL username and password in Database.java.

Compile and run Main.java to start the project.

 Example Output
     Connected successfully to the database!
     Student added successfully!
     Course added successfully!
     Application submitted successfully!
     Application processed successfully!

References

MySQL JDBC Connector Documentation

Oracle Java JDBC Tutorial

W3Schools – Java Database Connectivity (JDBC)

GeeksforGeeks – JDBC Basics

MySQL 8.0 Reference Manual — Database Creation and SQL Syntax

Author
Priyanka M
