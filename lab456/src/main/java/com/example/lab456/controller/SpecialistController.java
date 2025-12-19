package com.example.lab456.controller;

import com.example.lab456.model.Specialist;
import com.example.lab456.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specialists")
public class SpecialistController {

    @Autowired
    private SpecialistRepository specialistRepository;

    @GetMapping("/new")
    public String showSpecialistForm(Model model) {
        model.addAttribute("specialist", new Specialist());
        return "specialist-form";
    }

    @PostMapping("/new")
    public String createSpecialist(Specialist specialist) {
        specialistRepository.save(specialist);
        return "redirect:/specialists/new?success";
    }
}