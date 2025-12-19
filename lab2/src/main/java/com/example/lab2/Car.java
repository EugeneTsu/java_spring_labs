package com.example.lab2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car {

    private String model;

    public Car() {
        System.out.println("Car: constructor called");
    }

    @Value("Lada Granta")
    public void setModel(String model) {
        this.model = model;
        System.out.println("Car: setModel('" + model + "') called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Car: init() method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Car: destroy() method called");
    }

    public String getModel() {
        return model;
    }
}