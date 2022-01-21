package com.mvc.spring_demo_mvc.message_entries;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class MessageEntry {

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Last Name cannot be null")
    @Size(min = 1, message = "Last Name cannot be empty")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Size(min = 1, message = "Email cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email address")
    private String email;

    @NotNull(message = "Subject cannot be null")
    private String subject;

    @NotNull(message = "Message cannot be null")
    @Size(min = 25, message = "Message has to be longer than 25 characters")
    @Size(max = 500, message = "Message cannot be longer than 500 characters")
    private String message;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
