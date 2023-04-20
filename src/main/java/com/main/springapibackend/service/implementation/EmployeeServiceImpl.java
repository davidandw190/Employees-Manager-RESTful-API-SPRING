package com.main.springapibackend.service.implementation;

import com.main.springapibackend.model.Employee;
import com.main.springapibackend.repository.EmployeeRepo;
import com.main.springapibackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) throws Throwable {
        return (Employee) employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException ("User by ID "+ id +" was not found."));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

}
