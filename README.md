# School Management System

Trabalho prático N1 da disciplina de Programação Orientada a Objetos do curso de Inteligência Artificial e Ciência de Dados da Universidade de Uberaba

Professor: Clenio Eduardo da Silva

Aluno: Raphael Felix - 5174803

A simple Java application for managing students and teachers with grading functionality.

## Features

- **Student Management**: Add and view students
- **Teacher Management**: Add and view teachers  
- **Assignment System**: Assign students to teachers
- **Grading System**: Teachers can grade their assigned students
- **Grade Reports**: View detailed grade reports for students

## How to Run (Windows)

1. Compile all Java files:
   ```cmd
   javac -d out src\main\java\com\school\*.java
   ```

2. Run the application:
   ```cmd
   java -cp out com.school.SchoolManagementApp
   ```

## Application Structure

### Classes Overview

- **`Person`**: Abstract base class with common attributes (name, id, email)
- **`Student`**: Extends Person, manages student-specific data and grades
- **`Teacher`**: Extends Person, manages teacher data and student assignments
- **`Grade`**: Represents a grade given by a teacher to a student
- **`School`**: Main management class for students and teachers
- **`SchoolManagementApp`**: Main application with user interface
