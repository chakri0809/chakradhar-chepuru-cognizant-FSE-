package com.cognizant.hibernatexml;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cognizant.hibernatexml.model.Employee;


public class HibernateXmlDemo {

    private static SessionFactory factory;

    public static void main(String[] args) {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        HibernateXmlDemo demo = new HibernateXmlDemo();

        Integer newId = demo.addEmployee("Zara", "Ali", 2000);
        System.out.println("New employee saved with id: " + newId);

        demo.listEmployees();

        Employee fetched = demo.getEmployee(newId);
        System.out.println("Fetched: " + fetched);

        demo.updateEmployeeSalary(newId, 5000);
        demo.listEmployees();

        demo.deleteEmployee(newId);
        demo.listEmployees();

        factory.close();
    }

    public Integer addEmployee(String firstName, String lastName, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeId = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(firstName, lastName, salary);
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employeeId;
    }

    @SuppressWarnings("unchecked")
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Employee> employees = session.createQuery("FROM Employee").list();
            for (Employee e : employees) {
                System.out.println(e);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Employee getEmployee(int id) {
        Session session = factory.openSession();
        Employee employee = null;

        try {
            employee = session.get(Employee.class, id);
        } finally {
            session.close();
        }

        return employee;
    }

    public void updateEmployeeSalary(int id, int newSalary) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            employee.setSalary(newSalary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteEmployee(int id) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
