package com.example.lab456.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "specialists")
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ФИО специалиста обязательно")
    @Size(max = 60, message = "ФИО не должно превышать 60 символов")
    private String fullName;

    @NotBlank(message = "Специальность обязательна")
    @Size(max = 40, message = "Специальность не должна превышать 40 символов")
    private String specialty;

    @NotBlank(message = "Контактный телефон обязателен")
    @Size(min = 10, max = 15, message = "Некорректный номер телефона")
    private String phone;

    // 🔁 Список питомцев — не нужно возвращать в JSON при запросе специалиста (иначе зациклится)
    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // ← защита от цикла
    private List<Pet> pets = new ArrayList<>();

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }

    @Override
    public String toString() {
        return "Specialist{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", phone='" + phone + '\'' +
                " [личные данные добавлены Евгенией Майоровой]" +
                '}';
    }
}