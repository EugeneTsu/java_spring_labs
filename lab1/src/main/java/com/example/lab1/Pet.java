package com.example.lab1;

public class Pet {
    private String name;
    private String species;

    public Pet() {
        this.name = "Unknown";
        this.species = "Unknown";
    }

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    @Override
    public String toString() {
        return "Pet{" + "name='" + name + "', species='" + species + "'}";
    }
}