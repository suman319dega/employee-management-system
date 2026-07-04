# Employee Management System

A console-based **Employee Management System** developed using **Core Java** and **Object-Oriented Programming (OOP)** principles.

The application provides employee record management with role-specific behavior for **Developers, Managers, Testers, and General Employees**. It demonstrates the practical implementation of Java OOP concepts, the Collections Framework, method overloading, method overriding, runtime polymorphism, and exception handling.

---

## 📌 Project Overview

The **Employee Management System** is a menu-driven Java console application designed to manage employee records and perform employee-related operations.

The project started as a basic CRUD application and was progressively enhanced using important Core Java concepts.

The system supports different employee types:

- Developer
- Manager
- Tester
- General Employee

Each specialized employee inherits common properties and behaviors from the `Employee` class while providing role-specific work behavior and bonus calculation.

---

## ✨ Features

- Add new employees
- Support multiple employee types
- View all employee records
- Search employee by ID
- Search employee by name
- Update employee details
- Delete employee records
- Search employees by department
- Increase employee salary
- Display employees above a specified salary
- Display total number of employees
- Display department-wise employee count
- Display unique departments
- Display role-specific employee work behavior
- Calculate employee bonus based on employee type
- Prevent duplicate employee IDs
- Handle invalid menu input using exception handling

---

## 👨‍💻 Employee Types

### Developer

A Developer contains an additional `programmingLanguage` property.

**Work Behavior**

```text
Sumanth is writing Java code.
```

**Bonus**

```text
10% of Salary
```

### Manager

A Manager contains an additional `teamSize` property.

**Work Behavior**

```text
Rahul is managing a team of 10 employees.
```

**Bonus**

```text
20% of Salary
```

### Tester

A Tester contains an additional `testingTool` property.

**Work Behavior**

```text
Kiran is testing software using Selenium.
```

**Bonus**

```text
8% of Salary
```

### General Employee

A General Employee uses the default behavior provided by the `Employee` class.

**Bonus**

```text
5% of Salary
```

---

## 🧠 Object-Oriented Programming Concepts

### Encapsulation

Employee data is stored using private fields.

```java
private int id;
private String name;
private int age;
private String department;
private String designation;
private double salary;
```

The data is accessed and modified through getter and setter methods.

This provides controlled access to employee information and prevents direct modification of important employee data.

---

### Inheritance

The `Developer`, `Manager`, and `Tester` classes inherit common employee properties and behavior from the `Employee` class.

```java
public class Developer extends Employee
```

```java
public class Manager extends Employee
```

```java
public class Tester extends Employee
```

This represents an **IS-A relationship**.

```text
Developer IS-A Employee
Manager IS-A Employee
Tester IS-A Employee
```

Inheritance reduces code duplication and allows child classes to reuse properties and methods from the parent class.

---

### Method Overriding

Child classes provide their own implementation of common employee behavior.

```java
@Override
public void work()
```

The `calculateBonus()` method is also overridden by specialized employee classes.

```java
@Override
public double calculateBonus()
```

Each employee type performs work and calculates bonuses differently.

---

### Runtime Polymorphism

The application stores different employee types using `Employee` references.

```java
Employee employee;

employee = new Developer(...);
employee = new Manager(...);
employee = new Tester(...);
```

The actual object type determines which overridden method executes at runtime.

```java
employee.work();
employee.calculateBonus();
```

For example, if the actual object is a `Developer`, the Developer implementation of `work()` and `calculateBonus()` executes.

---

### Method Overloading

Employee searching is implemented using overloaded methods.

```java
searchEmployee(int id)
```

```java
searchEmployee(String name)
```

The same method name performs different search operations based on the parameter type.

This demonstrates **compile-time polymorphism**.

---

### `this` Keyword

The `this` keyword refers to the current object.

```java
this.name = name;
this.age = age;
this.salary = salary;
```

It is used to differentiate instance variables from constructor or method parameters.

---

### `super()` Constructor

The `super()` constructor is used by child classes to call the parent class constructor.

```java
super(id, name, age, department, designation, salary);
```

The parent `Employee` constructor initializes common employee properties.

The child class then initializes its own additional property.

Example:

```java
this.programmingLanguage = programmingLanguage;
```

---

## 📚 Java Collections Framework

### ArrayList

`ArrayList` is used to store employee objects dynamically.

```java
ArrayList<Employee> employees = new ArrayList<>();
```

The same collection can store different employee object types.

```text
Employee
Developer
Manager
Tester
```

This is possible because Developer, Manager, and Tester are child classes of Employee.

---

### HashMap

`HashMap` is used to calculate the number of employees in each department.

```java
HashMap<String, Integer>
```

The department name is stored as the **key**, and the employee count is stored as the **value**.

Example:

```text
Development : 3
Testing : 2
HR : 1
```

The project uses `getOrDefault()` to perform frequency counting.

```java
departmentCount.put(
    department,
    departmentCount.getOrDefault(department, 0) + 1
);
```

---

### HashSet

`HashSet` is used to store unique department names.

Example employee departments:

```text
Development
Testing
Development
HR
Testing
AI
```

The resulting HashSet contains:

```text
Development
Testing
HR
AI
```

Duplicate department names are automatically ignored.

---

## ⚠️ Exception Handling

The application handles invalid menu input using Java exception handling.

```java
try {
    choice = scanner.nextInt();
}
catch (InputMismatchException exception) {
    System.out.println(
        "Invalid input. Please enter a number."
    );

    scanner.nextLine();
    continue;
}
```

The `try` block contains code that may generate an exception.

The `catch` block handles the exception and prevents the application from terminating unexpectedly.

The invalid Scanner input is cleared using:

```java
scanner.nextLine();
```

The `continue` keyword skips the remaining statements in the current loop iteration and starts the next iteration.

---

## 📂 Project Structure

```text
Employee_Management_System/
│
├── Main.java
│   └── Handles user interaction and menu operations
│
├── Employee.java
│   └── Base Employee class
│
├── Developer.java
│   └── Developer-specific properties and behavior
│
├── Manager.java
│   └── Manager-specific properties and behavior
│
├── Tester.java
│   └── Tester-specific properties and behavior
│
├── EmployeeService.java
│   └── Employee management and business operations
│
├── README.md
│   └── Project documentation
│
└── .gitignore
    └── Files excluded from Git version control
```

---

## 🖥️ Application Menu

```text
===== EMPLOYEE MANAGEMENT SYSTEM =====

1. Add Employee
2. View Employees
3. Search Employee
4. Update Employee
5. Delete Employee
6. Search by Department
7. Increase Salary
8. Employees Above Salary
9. Total Employees
10. Department Wise Employee Count
11. View Unique Departments
12. Display Employee Work
13. Calculate Employee Bonus
14. Exit
```

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application Development |
| Core Java | Core Application Logic |
| OOP | Application Design |
| ArrayList | Employee Storage |
| HashMap | Department-wise Employee Counting |
| HashSet | Unique Department Storage |
| Scanner | Console Input |
| Exception Handling | Invalid Input Handling |

---

## 🚀 How to Run the Project

### Prerequisites

Install the **Java Development Kit (JDK)**.

Verify the Java installation:

```bash
java --version
```

Verify the Java compiler:

```bash
javac --version
```

### Clone the Repository

```bash
git clone <your-repository-url>
```

### Open the Project Directory

```bash
cd Employee_Management_System
```

### Compile the Java Files

```bash
javac *.java
```

### Run the Application

```bash
java Main
```

The Employee Management System menu will be displayed in the terminal.

---

## 💻 Sample Workflow

```text
===== EMPLOYEE MANAGEMENT SYSTEM =====

1. Add Employee
2. View Employees
3. Search Employee
4. Update Employee
5. Delete Employee
6. Search by Department
7. Increase Salary
8. Employees Above Salary
9. Total Employees
10. Department Wise Employee Count
11. View Unique Departments
12. Display Employee Work
13. Calculate Employee Bonus
14. Exit

Enter Choice: 1

Employee Types

1. Developer
2. Manager
3. Tester
4. General Employee

Select Employee Type: 1

Enter ID: 101
Enter Name: Sumanth
Enter Age: 21
Enter Department: Development
Enter Designation: Software Engineer
Enter Salary: 50000
Enter Programming Language: Java

Employee added successfully.
```

### Role-Specific Work Behavior

```text
Enter Choice: 12

Enter Employee ID: 101

Sumanth is writing Java code.
```

### Employee Bonus Calculation

```text
Enter Choice: 13

Enter Employee ID: 101

Employee Bonus: 5000.0
```

### Department-Wise Employee Count

```text
===== DEPARTMENT EMPLOYEE COUNT =====

Development : 3
Testing : 2
HR : 1
```

### Unique Departments

```text
===== UNIQUE DEPARTMENTS =====

Development
Testing
HR
AI
```

---

## 🎯 Concepts Demonstrated

This project demonstrates the practical implementation of:

- Classes and Objects
- Constructors
- Encapsulation
- Getters and Setters
- Inheritance
- IS-A Relationship
- `this` Keyword
- `super()` Constructor
- Method Overloading
- Method Overriding
- Compile-Time Polymorphism
- Runtime Polymorphism
- Java Collections Framework
- ArrayList
- HashMap
- HashSet
- Exception Handling
- Input Validation
- Menu-Driven Application Design

---

## ⚡ Current Limitation

Employee records are currently stored in memory using an `ArrayList`.

The employee data is available only while the application is running.

When the program terminates, the stored employee data is lost.

Persistent file or database storage has not yet been implemented.

---

## 🔮 Future Enhancements

- File-based employee data persistence
- Employee sorting using Comparator
- Custom exception handling
- Java Stream API integration
- JDBC database integration
- Employee authentication
- Department management
- Salary and payroll management
- Unit testing using JUnit
- Graphical User Interface
- Spring Boot REST API integration

---

## 📖 Learning Objective

The primary objective of this project is to strengthen **Core Java** and **Object-Oriented Programming** concepts through practical implementation.

The project demonstrates how a basic CRUD application can be progressively enhanced using:

```text
Basic CRUD
    ↓
Encapsulation
    ↓
Inheritance
    ↓
Method Overriding
    ↓
Runtime Polymorphism
    ↓
Method Overloading
    ↓
Java Collections
    ↓
Exception Handling
```

This project was developed as part of my practical Core Java learning journey to improve my understanding of Java application development and object-oriented design.

---

## 👨‍💻 Author

**DEGA SUMANTHYADAV**

Core Java | Object-Oriented Programming | Data Structures and Algorithms | Software Development

---

## 📄 License

This project is developed for educational and learning purposes.
