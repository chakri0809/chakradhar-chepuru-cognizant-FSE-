package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", ArrayList.class);
        LOGGER.debug("Loaded {} departments from department.xml", DEPARTMENT_LIST.size());
        LOGGER.info("END");
    }

    public List<Department> getAllDepartments() {
        LOGGER.info("START");
        LOGGER.info("END");
        return DEPARTMENT_LIST;
    }
}
