package com.example.lab1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Car car() {
        return new Car("Lada Granta");
    }

    @Bean
    public Pet pet() {
        return new Pet("Кошак", "Dog");
    }

    @Bean
    public Employee employee() {
        return new Employee("Евгения Майорова", 23, car(), pet());
    }
}