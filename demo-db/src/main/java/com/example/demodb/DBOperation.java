package com.example.demodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperation {

    private static Logger logger = LoggerFactory.getLogger(DBOperation.class);
    private Connection connection = null;


    public DBOperation() {
        try {
            createConnection();
            createEmployeeTable();
        } catch (Exception e) {
            logger.error("Exception in creating the connection with the error - {}", e);

        }
    }

    private void createEmployeeTable() throws SQLException {

        String sql = "create table if not exists employee (id int primary key auto_increment, name varchar(30), age int)";

        Statement statement = this.connection.createStatement();
        statement.execute(sql);

    }

    private void createConnection() throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "");

    }

    public void createEmployee(Employee employee) throws SQLException {
        // Write logic to insert an employee in the db
        // insert into employee(id, name, age) VALUES(1, "ABC", 30)

        String sql = "insert into employee (name, age) VALUES ('"
                + employee.getName() + "'," + employee.getAge() + ")";

        Statement statement = this.connection.createStatement();
        int result = statement.executeUpdate(sql);
        logger.info("Number of employees created - {}", result);
    }

    public void createEmployeeDynamic(Employee employee) throws SQLException {
        String sql = "insert into employee (name, age) VALUES (?, ?)";

        PreparedStatement statement = this.connection.prepareStatement(sql);

        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getAge());

        int result = statement.executeUpdate();

        logger.info("Number of employees created - {}", result);

    }

    public Employee getEmployee(Integer employeeId) throws SQLException {
        // Write logic to retrieve the employee details given the employeeId
        // select * from employee from employeeId = :employeeId
        String sql = "select * from employee where id = " + employeeId;

        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt(1); //rs.getInt("id")
            String name = rs.getString(2);
            int age = rs.getInt(3);

            return new Employee(id, name, age);
        }
        return null;
    }

    public Employee getEmployeeDynamic(Integer employeeId) throws SQLException {

        String sql = "select * from employee where id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, employeeId);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1); //rs.getInt("id")
            String name = rs.getString(2);
            int age = rs.getInt(3);

            return new Employee(id, name, age);
        }
        return null;
    }

    public List<Employee> getEmployees() throws SQLException {
        // Write logic to retrieve the employee details
        // select * from employee

        String sql = "select * from employee";
        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<Employee> employeeList = new ArrayList<>();
        while (rs.next()) {
            int employeeId = rs.getInt(1); //rs.getInt("id")
            String employeeName = rs.getString(2);
            int employeeAge = rs.getInt(3);

            Employee employee = new Employee(employeeId, employeeName, employeeAge);

            employeeList.add(employee);
        }
        return employeeList;
    }

    public Employee updateEmployee(Employee employee) {
        // update employee set name = ?, age = ? where id = ?
        // 1 - employee.getName(), 2 - employee.getAge(), 3 - employee.getId()

        return null;
    }

    public void deleteEmployee(int employeeId) throws SQLException {
        // delete from employee where id = ?
        // 1 - employeeId

        String sql = "delete from employee where id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setInt(1, employeeId);
        preparedStatement.execute();

    }
}
