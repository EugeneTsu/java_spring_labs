package com.example.lab2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Pet {

    private String name;
    private String species;

    public Pet() {
        System.out.println("Pet: constructor called");
    }

    @Value("Кошак")
    public void setName(String name) {
        this.name = name;
        System.out.println("Pet: setName('" + name + "') called");
    }

    @Value("Cat")
    public void setSpecies(String species) {
        this.species = species;
        System.out.println("Pet: setSpecies('" + species + "') called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Pet: init() method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pet: destroy() method called");
    }

    public String getName() { return name; }
    public String getSpecies() { return species; }
}