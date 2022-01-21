package com.mvc.spring_demo_mvc.controllers;

import com.mvc.spring_demo_mvc.entity.Employee;
import com.mvc.spring_demo_mvc.service.EmployeeService;
import com.mvc.spring_demo_mvc.service.EmployeeServiceImplementation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping({"/employees", "/staff"})
    public String getEmployeeList(Model model) {

        List<Employee> employees = employeeService.getEmployees();

        model.addAttribute("employees", employees);

        return "employee-list";
    }

    @RequestMapping("/employees/new")
    public String newEmployee(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "add-form";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    @RequestMapping("/employees/edit")
    public String editEmployee(@RequestParam("id") int id, Model model) {

        Employee employee = employeeService.getEmployee(id);

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @RequestMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("id") int id) {


        employeeService.deleteEmployee(id);


    	return "redirect:/employees";
    }
}
