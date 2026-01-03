👨‍💼 Employee Management System (Java Swing + JDBC)

The Employee Management System is a Java-based desktop application developed using Java Swing and JDBC to manage employee records efficiently. 
The application interacts with a MySQL database to perform essential employee-related operations such as adding, viewing, updating, and deleting employee details.
This project demonstrates core Java concepts, GUI development, database connectivity, and modular programming.

🚀 Features

-> Add new employee records

-> Fetch employee details by ID

-> Fetch all employee records in tabular format

-> Update employee details (Name, Gender, Salary)

-> Delete employee records

-> User-friendly GUI using Java Swing

-> Secure database interaction using Prepared Statements

🛠️ Technologies Used

--> Java

--> Java Swing (JFrame, JTable, JButton, JTextField, etc.)

--> JDBC (Java Database Connectivity)

--> MySQL

--> Eclipse IDE

--> WindowBuilder Plugin

--> MySQL Connector (JAR)


🧱 Project Structure
EmployeeManagementSystem
│
├── src
│   └── com.kodnest.jdbc.jframe
│       ├── index.java
│       ├── AddEmployee.java
│       ├── FetchEmployee.java
│       ├── FetchAll.java
│       ├── UpdateEmployee.java
│       ├── DeleteEmployee.java
│
└── mysql-connector-java.jar


⚙️ How It Works

--> index.java → Main dashboard for navigation

--> AddEmployee.java → Adds new employee details to the database

--> FetchEmployee.java → Fetches employee data using employee ID

--> FetchAll.java → Displays all employee records using JTable

--> UpdateEmployee.java → Updates existing employee details

--> DeleteEmployee.java → Deletes employee records by ID

--> Each module interacts with the MySQL database using JDBC and executes SQL queries securely using PreparedStatement.


🗄️ Database Details

--> Database: MySQL

--> Table: Employeee

--> Fields: id, name, gender, salary

--> Uses JDBC to execute SQL queries

--> Ensures secure and reliable data storage


▶️ How to Run the Project

--> Open the project in Eclipse IDE

--> Add MySQL Connector JAR to Build Path

--> Configure database credentials in JDBC connection code

--> Create the required database and table in MySQL

--> Run index.java

--> Perform employee management operations using the GUI


🎯 Learning Outcomes

--> Understanding Java Swing GUI development

--> Implementing CRUD operations using JDBC

--> Working with MySQL databases

--> Using PreparedStatement for secure SQL execution

--> Handling exceptions and user input validation

--> Designing modular desktop applications


👤 Author

Manjunatha R
Computer Science & Engineering
Government Engineering College, Karwar
