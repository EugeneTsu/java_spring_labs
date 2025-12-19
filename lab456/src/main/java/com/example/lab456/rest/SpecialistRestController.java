package com.example.lab456.rest;

import com.example.lab456.model.Specialist;
import com.example.lab456.repository.SpecialistRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialists")
public class SpecialistRestController {

    @Autowired
    private SpecialistRepository specialistRepository;

    // Получить всех специалистов
    @GetMapping
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    // Создать нового специалиста
    @PostMapping
    public Specialist createSpecialist(@Valid @RequestBody Specialist specialist) {
        return specialistRepository.save(specialist);
    }

    // Получить одного специалиста по ID
    @GetMapping("/{id}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable Long id) {
        Specialist specialist = specialistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Специалист не найден"));
        return ResponseEntity.ok(specialist);
    }

    // Удалить специалиста
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialist(@PathVariable Long id) {
        if (!specialistRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        specialistRepository.deleteById(id);
        return ResponseEntity.ok("Специалист удалён");
    }
}