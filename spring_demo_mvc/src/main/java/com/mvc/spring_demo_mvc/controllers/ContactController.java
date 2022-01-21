package com.mvc.spring_demo_mvc.controllers;

import com.mvc.spring_demo_mvc.message_entries.MessageEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String ContactForm(Model model) {

        MessageEntry messageEntry = new MessageEntry();
        model.addAttribute("messageEntry", messageEntry);

        return "contact";
    }

    @PostMapping("/contact")
    public String processContactMessage(@Valid @ModelAttribute("messageEntry") MessageEntry messageEntry,
                                        BindingResult result) {



        if (result.hasErrors()) {
            return "contact";
        }

        return "contact-success";
    }

}
