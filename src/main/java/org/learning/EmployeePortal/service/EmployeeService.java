package org.learning.EmployeePortal.service;

import org.learning.EmployeePortal.exception.GlobalExceptionHandler;
import org.learning.EmployeePortal.model.Employee;
import org.learning.EmployeePortal.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    // To get list of all employees
    public List<Employee> getAllEmp() throws GlobalExceptionHandler {
        // return repo.getAllEmp();
        return repo.findAll();
    }

    // To get employee using EmpID
    public Employee getEmp(int empId) {
        // return repo.getEmp(empId);
        return repo.findById(empId).orElse(null);
    }

    // To add employee
    public String addEmp(Employee emp) {
        // return repo.addEmp(emp);
        if (repo.existsById(emp.getEmpId()))
            return "Employee with same empId already exists";
        String response = validate(emp);
        if (response.equals("true")) {
            repo.save(emp);
            return "Employee added successfully";
        }
        return response;
    }

    public String validate(Employee emp) {
        String[] departments = { "HR", "IT", "CS", "ST" };
        for (String department : departments) {
            if (department.equals(emp.getDepartment())) {
                int salary = emp.getSalary();
                if (salary <= 5000000) {
                    return "true";
                }
                return "Salary should be less than 50,00,000";
            }
        }
        return "Wrong department entry";
    }

    // To update an employee data
    public String updateEmp(Employee emp) {
        // return repo.updateEmp(emp);
        if (repo.existsById(emp.getEmpId())) {
            String response = validate(emp);
            if (response.equals("true")) {
                repo.save(emp);
                return "Employee updated successfully";
            }
            return response;
        }
        return "Employee with this empId does not exists";
    }

    // To delete an employee data
    public String deleteEmp(int empId) {
        // return repo.deleteEmp(empId);
        if (repo.existsById(empId)) {
            repo.deleteById(empId);
            return "Employee deleted successfully";
        }
        return "Employee with this empId does not exist";
    }
}
