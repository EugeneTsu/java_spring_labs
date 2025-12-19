package com.example.lab456.controller;

import com.example.lab456.model.Owner;
import com.example.lab456.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/new")
    public String showOwnerForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner-form";
    }

    @PostMapping("/new")
    public String createOwner(Owner owner) {
        ownerRepository.save(owner);
        return "redirect:/owners/new?success";
    }
}