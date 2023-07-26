package com.example.demojpa.daos;

import com.example.demojpa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Transactional
    @Query("update Employee e set e.name = ?1, e.age = ?2, e.country = ?3, e.yearsOfExp = ?4, e.address = ?5 where e.id = ?6")
    void update(String name, Integer age, String country, Integer yoe, String address, Integer id);
}
