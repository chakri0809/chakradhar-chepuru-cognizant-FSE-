package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
        LOGGER.debug("Loaded {} employees from employee.xml", EMPLOYEE_LIST.size());
        LOGGER.info("END");
    }

    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        LOGGER.info("END");
        return EMPLOYEE_LIST;
    }

    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START");
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                LOGGER.info("END");
                return employee;
            }
        }
        LOGGER.info("END");
        throw new EmployeeNotFoundException("Employee not found for id: " + employee.getId());
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("START");
        Iterator<Employee> iterator = EMPLOYEE_LIST.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId().equals(id)) {
                iterator.remove();
                LOGGER.info("END");
                return;
            }
        }
        LOGGER.info("END");
        throw new EmployeeNotFoundException("Employee not found for id: " + id);
    }
}
