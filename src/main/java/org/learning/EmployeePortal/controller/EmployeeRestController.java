package org.learning.EmployeePortal.controller;

import org.learning.EmployeePortal.exception.GlobalExceptionHandler;
import org.learning.EmployeePortal.model.Employee;
import org.learning.EmployeePortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService service;

    // To get list of all employees
    @GetMapping("allemp")
    public List<Employee> getAllEmp() {
        System.out.println("Get a list of all employees");
        try {
            return service.getAllEmp();
        } catch (GlobalExceptionHandler e) {
            throw new RuntimeException(e);
        }
    }

    // To get employee using empId
    @GetMapping("emp/{empId}")
    public Employee getEmp(@PathVariable("empId") Integer empId) {
        return service.getEmp(empId);
    }

    // To add a new employee
    @PostMapping("emp")
    public String addEmp(@Valid @RequestBody Employee emp) {
        return service.addEmp(emp);
    }

    // To update an employee
    @PutMapping("emp")
    public String updateEmp(@Valid @RequestBody Employee emp) {
        return service.updateEmp(emp);
    }

    // To delete an employee
    @DeleteMapping("emp/{empId}")
    public String deleteEmp(@PathVariable("empId") int empId) {
        return service.deleteEmp(empId);
    }
}
