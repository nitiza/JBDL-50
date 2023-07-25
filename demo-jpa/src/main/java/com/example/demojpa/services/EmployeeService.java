package com.example.demojpa.services;

import com.example.demojpa.daos.EmployeeRepository;
import com.example.demojpa.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void create(Employee employee){
        employeeRepository.save(employee);

    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Integer employeeId) {
        return employeeRepository
                .findById(employeeId)
                .orElse(null);
    }

    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
