package com.example.demo.repository;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository  {
    int count();

    int save(Employee employee);

    int update(Employee employee, Long id);

    int deleteById(Long id);

    List<Employee> findAll();

    Optional<Employee> findById(Long id);
}