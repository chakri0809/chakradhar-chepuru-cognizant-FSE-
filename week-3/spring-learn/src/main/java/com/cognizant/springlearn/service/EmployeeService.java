package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        List<Employee> employees = employeeDao.getAllEmployees();
        LOGGER.info("END");
        return employees;
    }

    @Transactional
    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START");
        Employee updated = employeeDao.updateEmployee(employee);
        LOGGER.info("END");
        return updated;
    }

    @Transactional
    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("START");
        employeeDao.deleteEmployee(id);
        LOGGER.info("END");
    }
}
