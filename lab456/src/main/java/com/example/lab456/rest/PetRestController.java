package com.example.lab456.rest;

import com.example.lab456.model.Pet;
import com.example.lab456.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetRestController {

    @Autowired
    private PetRepository petRepository;

    // Получить всех питомцев
    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // Создать нового питомца
    @PostMapping
    public Pet createPet(@Valid @RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    // Получить одного питомца по ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Питомец не найден"));
        return ResponseEntity.ok(pet);
    }

    // Удалить питомца
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Long id) {
        if (!petRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        petRepository.deleteById(id);
        return ResponseEntity.ok("Питомец удалён");
    }
}