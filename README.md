# Java SQL Database Operations

This project demonstrates basic database operations using Java with a PostgreSQL database. It includes functionalities to retrieve, update, and delete data from the Students table.

## Overview

The `StudentDBConnection` class connects to a PostgreSQL database and provides methods to perform various operations on the Students table. These operations include retrieving all student records, adding a new student, updating a student's email address, and deleting a student record.

## Getting Started

To run this project, ensure you have Java installed on your system along with the PostgreSQL JDBC driver. You'll also need access to a PostgreSQL database with a table named `students`.

## Usage
1. Download or clone the Github repository at https://github.com/Areej504/StudentDBConnection.git

2. Set Up Database Connection: Modify the `main` method in the `StudentDBConnection` class to specify your database URL, username, and password.

3. Run the Application: Compile and run the `StudentDBConnection` class. This will establish a connection to your database and execute various operations.

## Functionality

- Retrieving all Students: To retrieve and display all student records from the database, call the `getAllStudents()` method.

- Adding a Student: To add a new student to the database, call the `addStudent()` method and provide the student's first name, last name, email, and enrollment date.

- Updating a Student's Email: To update the email address for a specific student, call the `updateStudentEmail()` method with the student's ID and the new email address.

- Deleting a Student: To delete a student record from the database, call the `deleteStudent()` method and provide the student's ID.

## Dependencies

- PostgreSQL JDBC Driver

## Video Demonstration
Watch the Video below for a live demo of the application's functionality!
https://youtu.be/V7VY3Z2LB78

## Author
Areej Mahmoud 101218260


