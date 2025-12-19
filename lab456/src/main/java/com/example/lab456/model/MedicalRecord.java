package com.example.lab456.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Диагноз обязателен")
    @Size(max = 500, message = "Диагноз слишком длинный")
    private String diagnosis;

    @NotBlank(message = "Лечение обязательно")
    @Size(max = 500, message = "Описание лечения слишком длинное")
    private String treatment;

    @NotBlank(message = "Дата последнего визита обязательна")
    @Size(max = 20, message = "Формат даты: ДД.ММ.ГГГГ")
    private String lastVisitDate;

    // 🔁 Обратная связь на Pet — но её НЕ нужно сериализовать в JSON
    @OneToOne(mappedBy = "medicalRecord")
    @JsonIgnore // ← вот эта строчка — защищает от зацикливания
    private Pet pet;

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }
    public String getLastVisitDate() { return lastVisitDate; }
    public void setLastVisitDate(String lastVisitDate) { this.lastVisitDate = lastVisitDate; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", lastVisitDate='" + lastVisitDate + '\'' +
                " [данные клиники, оформленные Евгенией Майоровой]" +
                '}';
    }
}