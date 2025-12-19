package com.example.lab1;

public class Employee {
    private String name;
    private int age;
    private Car car;
    private Pet pet;

    // DI через конструктор (рекомендуется в Spring)
    public Employee(String name, int age, Car car, Pet pet) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.pet = pet;
    }

    public String introduce() {
        return "Employee: " + name + ", " + age + " years old. Car: " + car.getModel() + ". Pet: " + pet.getName() + ".";
    }

    // Геттеры
    public String getName() { return name; }
    public int getAge() { return age; }
    public Car getCar() { return car; }
    public Pet getPet() { return pet; }
}