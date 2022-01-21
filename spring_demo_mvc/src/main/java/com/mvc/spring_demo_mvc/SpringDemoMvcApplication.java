package com.mvc.spring_demo_mvc;

import com.mvc.spring_demo_mvc.configuration.BeanConfig;
import com.mvc.spring_demo_mvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.io.File;


@SpringBootApplication
public class SpringDemoMvcApplication {

	public static void main(String[] args) {

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		//context.start();
		SpringApplication.run(SpringDemoMvcApplication.class, args);



	}

}
