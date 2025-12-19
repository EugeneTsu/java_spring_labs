package com.example.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    // Внедряем Employee через DI
    private final Employee employee;

    @Autowired
    public WebController(Employee employee) {
        this.employee = employee;
    }

    // /hello?name=Женя → "Hello Женя"
    // /hello → "Hello world!"
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        if (name != null && !name.trim().isEmpty()) {
            return "Hello " + name + "!";
        }
        return "Hello world!";
    }

    // /about → "about us"
    @GetMapping("/about")
    public String about() {
        return "about us";
    }

    // /options → "options"
    // /options?any=1 → "not an option"
    @GetMapping("/options")
    public String options(@RequestParam(required = false) String any) {
        if (any == null) {
            return "options";
        }
        return "not an option";
    }

    @GetMapping("/employee")
    public String employeeInfo() {
        return employee.introduce();
    }
}

