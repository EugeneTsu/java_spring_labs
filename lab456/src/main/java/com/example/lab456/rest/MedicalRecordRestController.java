package com.example.lab456.rest;

import com.example.lab456.model.MedicalRecord;
import com.example.lab456.repository.MedicalRecordRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordRestController {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    // Получить все истории болезни
    @GetMapping
    public List<MedicalRecord> getAllRecords() {
        return medicalRecordRepository.findAll();
    }

    // Создать новую историю болезни
    @PostMapping
    public MedicalRecord createRecord(@Valid @RequestBody MedicalRecord record) {
        return medicalRecordRepository.save(record);
    }

    // Получить одну историю болезни по ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getRecordById(@PathVariable Long id) {
        MedicalRecord record = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("История болезни не найдена"));
        return ResponseEntity.ok(record);
    }

    // Удалить историю болезни
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        if (!medicalRecordRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        medicalRecordRepository.deleteById(id);
        return ResponseEntity.ok("История болезни удалена");
    }
}