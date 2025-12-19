package com.example.lab456.rest;

import com.example.lab456.model.Owner;
import com.example.lab456.repository.OwnerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerRestController {

    @Autowired
    private OwnerRepository ownerRepository;

    // Получить всех владельцев
    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    // Создать нового владельца
    @PostMapping
    public Owner createOwner(@Valid @RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    // Получить одного владельца по ID
    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Владелец не найден"));
        return ResponseEntity.ok(owner);
    }

    // Удалить владельца
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        if (!ownerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ownerRepository.deleteById(id);
        return ResponseEntity.ok("Владелец удалён");
    }
}