package com.mvc.spring_demo_mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(path="/processLogin", method= RequestMethod.POST)
    public String processLogin(@RequestParam("user") String user, @RequestParam("password") String pass, Model model) {

        String [] info_usuario = {user, pass};
        model.addAttribute("login", info_usuario);

        return "process-login";
    }
}

