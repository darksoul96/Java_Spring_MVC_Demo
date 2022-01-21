package com.mvc.spring_demo_mvc.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/", "/index", "/home"})
    public String index(Model model) {

        model.addAttribute("fecha", new java.util.Date());

        return "index";
    }


}


