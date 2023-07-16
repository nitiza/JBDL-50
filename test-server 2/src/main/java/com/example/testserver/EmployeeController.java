package com.example.testserver;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    /**
     * CRUD operations that can handle employee lifecycle
     */

    private HashMap<Integer, Employee> employeeHashMap = new HashMap<>();

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        // return the list of all the employees
        return this.employeeHashMap.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/employee/id/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return this.employeeHashMap.get(id);
    }

    @PostMapping("/employee")
    public void createEmployee(@RequestBody Employee employee) throws Exception {
        if (employee.getId() == null) {
            throw new Exception("Employee id cannot be null");
        }
        this.employeeHashMap.put(employee.getId(), employee);
    }

    @PutMapping("/employee/id/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) throws Exception {

        if (!this.employeeHashMap.containsKey(employee.getId()) || employee.getId() == null) {
            throw new Exception("Not a valid employee, updation failed");
        }

        return this.employeeHashMap.put(employee.getId(), employee);
    }

    @PatchMapping("/employee/id/{id}")
    public Employee updatePartialEmployee(@RequestBody Employee employee) throws Exception {

        if (employee.getId() == null || !this.employeeHashMap.containsKey(employee.getId())) {
            throw new Exception("Not a valid employee, updation failed");
        }

        Employee employeeFromMap = this.employeeHashMap.get(employee.getId());

        if (employee.getAge() != null) {
            employeeFromMap.setAge(employee.getAge());
        }
        if (employee.getName() != null) {
            employeeFromMap.setName(employee.getName());
        }

        return this.employeeHashMap.put(employee.getId(), employeeFromMap);
    }

    @DeleteMapping("/employee")
    public Employee deleteEmployee(@RequestParam("id") int id) {
        return this.employeeHashMap.remove(id);
    }
}
