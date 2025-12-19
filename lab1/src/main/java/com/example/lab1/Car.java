package com.example.lab1;

public class Car {
    private String model;

    public Car() {
        this.model = "Unknown";
    }

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + '}';
    }
}