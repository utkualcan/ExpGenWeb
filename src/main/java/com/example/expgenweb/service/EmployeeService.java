package com.example.expgenweb.service;

import com.example.expgenweb.entity.Employee;
import com.example.expgenweb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ExpenseService expenseService;

    public List<Employee> findAllWithManagers() {
        return employeeRepository.findAllWithManagers();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer empno) {
        return employeeRepository.findById(empno).orElse(null);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteById(Integer empno) {
        employeeRepository.deleteById(empno);
    }

    public Double getEmployeeTotalExpenses(Integer empno) {
        return expenseService.getTotalAmountForEmployee(empno);
    }

    public Map<Integer, Double> getAllEmployeeTotalExpenses() {
        return expenseService.getAllEmployeesTotalAmount();
    }
}