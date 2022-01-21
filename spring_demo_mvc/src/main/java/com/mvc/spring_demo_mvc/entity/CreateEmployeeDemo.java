package com.mvc.spring_demo_mvc.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class CreateEmployeeDemo {

    public static void main(String[] args) {
        File f = new File("hibernate.cfg.xml");
        SessionFactory sessionFactory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            System.out.println("Creating new Employee object...");
            session.beginTransaction();
            Employee employee1 = new Employee("Agustin", "Ruiz", "aruiz@email.com", "12345678");
            Employee employee2 = new Employee("Jeannie", "Mullins", "jmullins@email.com", "12345678");
            Employee employee3 = new Employee("Fredrick", "Vaughn", "fvaughn@email.com", "12345678");
            Employee employee4 = new Employee("Shelley", "Powell", "spowell@email.com", "12345678");

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);
            session.save(employee4);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
