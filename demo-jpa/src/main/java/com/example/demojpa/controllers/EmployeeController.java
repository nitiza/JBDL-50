package com.example.demojpa.controllers;


import com.example.demojpa.dtos.CreateEmployeeRequest;
import com.example.demojpa.dtos.GetEmployeesResponse;
import com.example.demojpa.models.Employee;
import com.example.demojpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employee/all")
    public GetEmployeesResponse getEmployees() {

        return GetEmployeesResponse
                .builder()
                .employees(employeeService.getAll())
                .build();

    }

    @GetMapping("/employee/{id}")
    public GetEmployeesResponse getEmployee(@PathVariable("id") Integer employeeId) {

        return GetEmployeesResponse
                .builder()
                .employees(Arrays.asList(employeeService.getById(employeeId)))
                .build();
    }

    @PostMapping("/employee")
    public void createEmployee(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest) {

        employeeService.create(createEmployeeRequest.to());

    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam("id") Integer employeeId){
        employeeService.delete(employeeId);
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        employeeService.update(id, createEmployeeRequest.to());
    }


}
