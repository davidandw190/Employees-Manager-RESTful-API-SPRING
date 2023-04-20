package com.main.springapibackend.service;

import com.main.springapibackend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> findAllEmployees();

    Employee updateEmployee(Employee employee);

   Employee findEmployeeById(Long id) throws Throwable;

    void deleteEmployee(Long id);
}
