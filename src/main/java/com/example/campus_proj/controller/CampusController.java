package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.Campus;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campus")
public class CampusController {
    @Autowired
    CampusService campusService;
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("campuses", campusService.getAll());
        return "campus";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Campus campus = campusService.getById(id);
        model.addAttribute("campus", campus);
        return "campus-details";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Campus campus) {
        campusService.create(campus);
        return "redirect:/campus";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        campusService.delete(id);
        return "redirect:/campus";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("campus") Campus campus) {
        campusService.update(campus);
        return "redirect:/campus";
    }
    @GetMapping("/edit/{id}")
    public String getCampus(@PathVariable("id") Long id, Model model) {
        Campus campus = campusService.getById(id);
        model.addAttribute("campus", campus);
        return "editCampus";
    }
    @PostMapping("/edit/{id}")
    public String editCampus(@ModelAttribute Campus campus) {
        campusService.update(campus);
        return "redirect:/campus";
    }
}