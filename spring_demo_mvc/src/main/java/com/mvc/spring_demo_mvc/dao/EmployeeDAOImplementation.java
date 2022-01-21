package com.mvc.spring_demo_mvc.dao;

import com.mvc.spring_demo_mvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.io.File;
import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    //@Autowired
    //private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployees() {

        //Session session = sessionFactory.getCurrentSession();

        File f = new File("hibernate.cfg.xml");
        SessionFactory sessionFactory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();

        //create query
        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

        //commit transaction
        session.getTransaction().commit();

        session.close();

        return employees;
    }


    @Override
    public void saveEmployee(Employee employee) {

        File f = new File("hibernate.cfg.xml");
        SessionFactory sessionFactory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        // save/upate the employee
        session.saveOrUpdate(employee);

        session.close();
    }

    @Override
    public Employee getEmployee(int id) {

        File f = new File("hibernate.cfg.xml");
        SessionFactory sessionFactory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        File f = new File("hibernate.cfg.xml");
        SessionFactory sessionFactory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
