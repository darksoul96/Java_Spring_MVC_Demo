package com.mvc.spring_demo_mvc.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "lastName", nullable = false)
    public String lastName;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "phone", nullable = false)
    public String phone;



    public Employee() {
    }


    public Employee(String name, String lastName, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Employee(int id, String name, String lastName, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + '}';
    }



}
