package com.example.lab2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Employee {

    private String name;
    private int age;
    private Car car;
    private Pet pet;

    public Employee() {
        System.out.println("Employee: constructor called");
    }

    @Autowired
    @Qualifier("car") // хотя имя бина совпадает с именем класса, всё равно добавим для задания
    public void setCar(Car car) {
        this.car = car;
        System.out.println("Employee: setCar() called");
    }

    @Autowired
    @Qualifier("pet")
    public void setPet(Pet pet) {
        this.pet = pet;
        System.out.println("Employee: setPet() called");
    }

    @Value("Евгения Майорова")
    public void setName(String name) {
        this.name = name;
        System.out.println("Employee: setName('" + name + "') called");
    }

    @Value("23")
    public void setAge(int age) {
        this.age = age;
        System.out.println("Employee: setAge(" + age + ") called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Employee: init() method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Employee: destroy() method called");
    }

    public String introduce() {
        return "Employee: " + name + ", " + age + " years old. Car: " + car.getModel() + ". Pet: " + pet.getName() + ".";
    }
}