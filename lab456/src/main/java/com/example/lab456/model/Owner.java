package com.example.lab456.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ФИО владельца обязательно")
    @Size(max = 60, message = "ФИО не должно превышать 60 символов")
    private String fullName;

    @NotBlank(message = "Телефон обязателен")
    @Size(min = 10, max = 15, message = "Некорректный номер телефона")
    private String phone;

    @Size(max = 100, message = "Email не должен превышать 100 символов")
    private String email;

    // 🔁 Питомцы владельца — не нужно возвращать в JSON (иначе: Owner → Pet → Owner → ...)
    @ManyToMany(mappedBy = "owners")
    @JsonIgnore // ← защита от бесконечного цикла
    private List<Pet> pets = new ArrayList<>();

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                " [добавлено Евгенией Майоровой]" +
                '}';
    }
}