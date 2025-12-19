package com.example.lab2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfigManual {

    @Bean
    @Scope("prototype")
    public Car manualCar() {
        System.out.println("AppConfig: creating Car bean manually");
        Car car = new Car();
        // Нельзя вызвать сеттеры с @Value — они не обрабатываются вручную!
        // Поэтому устанавливаем вручную:
        try {
            car.getClass().getMethod("setModel", String.class).invoke(car, "Lada Granta (manual)");
        } catch (Exception ignored) {}
        return car;
    }

    @Bean
    @Scope("singleton")
    public Pet manualPet() {
        System.out.println("AppConfig: creating Pet bean manually");
        Pet pet = new Pet();
        try {
            pet.getClass().getMethod("setName", String.class).invoke(pet, "Кошак (manual)");
            pet.getClass().getMethod("setSpecies", String.class).invoke(pet, "Cat");
        } catch (Exception ignored) {}
        return pet;
    }

    @Bean
    @Scope("singleton")
    public Employee manualEmployee() {
        System.out.println("AppConfig: creating Employee bean manually");
        Employee emp = new Employee();
        emp.setName("Евгения Майорова (manual)");
        emp.setAge(23);
        emp.setCar(manualCar());
        emp.setPet(manualPet());
        return emp;
    }
}