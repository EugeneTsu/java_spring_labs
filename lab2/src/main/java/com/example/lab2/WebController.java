package com.example.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private final Employee employee;

    @Autowired
    public WebController(Employee employee) {
        this.employee = employee;
    }

    @GetMapping("/employee")
    public String employeeInfo() {
        return employee.introduce();
    }

    @GetMapping("/lab2")
    public String lab2() {
        return "Лабораторная №2: IoC и DI через аннотации. Автор: Евгения Майорова";
    }
}