package com.example.lab456.controller;

import com.example.lab456.model.Pet;
import com.example.lab456.repository.OwnerRepository;
import com.example.lab456.repository.PetRepository;
import com.example.lab456.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private SpecialistRepository specialistRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/new")
    public String showPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("specialists", specialistRepository.findAll());
        model.addAttribute("owners", ownerRepository.findAll());
        return "pet-form";
    }

    @PostMapping("/new")
    public String createPet(Pet pet) {
        // Сохраняем питомца в БД
        petRepository.save(pet);
        return "redirect:/pets/new?success";
    }
}