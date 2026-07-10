package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.info("END");
        return employees;
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START");
        Employee updated = employeeService.updateEmployee(employee);
        LOGGER.info("END");
        return updated;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        LOGGER.info("START");
        employeeService.deleteEmployee(id);
        LOGGER.info("END");
    }
}
