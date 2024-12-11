# Employee Expenditure Handler 

## About 
The project is designed to manage, compute, and track all the expenses associated with each employee in the organization. It leverages the power of Jakarta EE with Spring Data JPA, Spring MVC, Lombok, and Java SDK version 17 to handle back-end operations, Persisting and fetching data from a Cassandra database.

## Features 

- **Real-Time Employee Expense Tracking**: Track the expenditures of each employee in real time. With each transaction, the total expense count of an employee gets updated, ensuring up-to-date information is always available.

- **Comprehensive Expense Information**: View detailed expenses for each employee. This includes individual transaction details such as date, time, amount, and expense category.

- **Secure and Robust**: The system is designed with an emphasis on data security and application robustness. Extensive error handling and logging ensures any issues can be quickly detected and resolved.

## ## Getting Started

These instructions will guide you through the process of setting up a local development and testing environment.

### Prerequisites

Ensure you have the following software installed on your local machine:

- Java SDK version 17
- Spark
- Kafka
- MySQL
- Apache Cassandra
- Maven
- Your preferred IDE (Like IntelliJ IDEA)

### Clone the Repository

First, clone the repository to your local machine. You can do this by running the following command in your terminal:

```bash
git clone https://github.com/your_username/employee-expenditure-handler.git

```
### Set Up MySQL

Set up a MySQL instance and create a database. Also, create 'employee' table inside it. Make sure to start your MySQL.

### Set Up Kafka

Set up a Kafka instance.Configurate right ports for kafka. Make sure to start your Cassandra server:

```bash
# Run cassandra
sudo systemctl start cassandra
```

### Set Up Spark

Set up a Spark instance.Configurate right ports for spark. Make sure to start your Cassandra server:

```bash
# Run cassandra
sudo systemctl start spark
```

### Set Up Cassandra

Set up a Cassandra instance and create a key space 'expenses_ks'. Also, create 'expenses' table inside it. Make sure to start your Cassandra server:

```bash
# Run cassandra
sudo systemctl start cassandra
```

### Run the Application

Open the project in your preferred IDE and run `ExpGenWebApplication.java`. This will start the Spring Boot application.

## Usage

The software comes with an intuitive user interface, making it easy to input and view transactions. To add a new employee, simply enter the necessary details and click the "Add" button. The total expenses of each employee are calculated and updated in real time. 

## Contributing

Any contributions to expand the functionalities or to improve the codebase are welcome. Have a look at the open issues to start. If you have an idea for improvement or have found a bug to report, please create a new issue so it can be addressed. 

## License 

[LICENSE](https://www.mit.edu/~amini/LICENSE.md)

## Contact 

[Utku Alcan] - [Mail](aalcan.utku@gmail.com) - [Linkedin](https://www.linkedin.com/in/utku-alcan-12090929b/)

Project Link: [ExpGenWeb](https://github.com/utkualcan/ExpGenWeb)

Related Project Link: [expense-data-generator](https://github.com/utkualcan/expense-data-generator)
