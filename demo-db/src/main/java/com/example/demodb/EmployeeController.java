package com.example.demodb;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class EmployeeController {

    // db server - 127.0.0.1 3306
    // app server - 127.0.0.1 8081

    private DBOperation dbOperation;

    public EmployeeController() {
        this.dbOperation = new DBOperation();

    }




    @GetMapping("/employee")
    public List<Employee> getEmployees() throws SQLException {
        // return the list of all the employees
        return dbOperation.getEmployees();

    }

    @GetMapping("/employee/id/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) throws SQLException {
        return dbOperation.getEmployeeDynamic(id);
    }

    @PostMapping("/employee")
    public void createEmployee(@RequestBody Employee employee) throws Exception {
        dbOperation.createEmployeeDynamic(employee);

    }

    @PutMapping("/employee/id/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
        return null;

    }

    @PatchMapping("/employee/id/{id}")
    public Employee updatePartialEmployee(@RequestBody Employee employee) throws Exception {

        return null;
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam("id") int id) throws SQLException {
        dbOperation.deleteEmployee(id);
    }
}
