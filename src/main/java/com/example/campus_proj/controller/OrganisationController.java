package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organisation")
public class OrganisationController {
    @Autowired
    OrganisationService organisationService;
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("organisations", organisationService.getAll());
        return "organisation";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Organisation organisation = organisationService.getById(id);
        model.addAttribute("organisation", organisation);
        return "organisation-details";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Organisation organisation) {
        organisationService.create(organisation);
        return "redirect:/organisation";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        organisationService.delete(id);
        return "redirect:/organisation";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("organisation") Organisation organisation) {
        organisationService.update(organisation);
        return "redirect:/organisation";
    }
    @GetMapping("/edit/{id}")
    public String getOrganisation(@PathVariable("id") Long id, Model model) {
        Organisation organisation = organisationService.getById(id);
        model.addAttribute("organisation", organisation);
        return "editOrganisation";
    }
    @PostMapping("/edit/{id}")
    public String editOrganisation(@ModelAttribute Organisation organisation) {
        organisationService.update(organisation);
        return "redirect:/organisation";
    }
}