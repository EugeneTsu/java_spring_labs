package com.example.lab456.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets") // ← название таблицы в БД
public class Pet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ← ID, автоматически увеличивается

    @NotBlank(message = "Имя обязательно")
    @Size(max = 30, message = "Имя не должно превышать 30 символов")
    private String name;

    @NotBlank
    @Size(max = 20)
    private String species;

    private int age;

    // One-to-One: Pet ↔ MedicalRecord
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "medical_record_id") // ← внешний ключ в таблице pets
    private MedicalRecord medicalRecord;

    // Many-to-One: Pet → Specialist
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    // Many-to-Many: Pet ↔ Owner
    @ManyToMany
    @JoinTable(
            name = "pet_owners", // ← промежуточная таблица
            joinColumns = @JoinColumn(name = "pet_id"), // ← колонка в pet_owners, ссылается на pet
            inverseJoinColumns = @JoinColumn(name = "owner_id") // ← ссылается на owner
    )
    private List<Owner> owners = new ArrayList<>();

    // getters / setters — нужно добавить!
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord; }
    public Specialist getSpecialist() { return specialist; }
    public void setSpecialist(Specialist specialist) { this.specialist = specialist; }
    public List<Owner> getOwners() { return owners; }
    public void setOwners(List<Owner> owners) { this.owners = owners; }
}