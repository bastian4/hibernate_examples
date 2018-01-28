package com.github.pabloo99.dao;

import com.github.pabloo99.connection.HibernateUtil;
import com.github.pabloo99.entity.Employee;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDao {

    public List<Employee> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        List<Employee> employees =
                session.createQuery("FROM Employee").
                        getResultList();

        session.getTransaction().commit();

        return employees;
    }
}