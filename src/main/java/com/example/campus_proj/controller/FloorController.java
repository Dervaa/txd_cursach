package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/floor")
public class FloorController {
    @Autowired
    FloorService floorService;
    @Autowired
    CampusService campusService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("floors", floorService.getAll());
        model.addAttribute("campuses", campusService.getAll());
        return "floor";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Floor floor = floorService.getById(id);
        model.addAttribute("floor", floor);
        return "floor-details";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Floor floor) {
        floorService.create(floor);
        return "redirect:/floor";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        floorService.delete(id);
        return "redirect:/floor";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("floor") Floor floor) {
        floorService.update(floor);
        return "redirect:/floor";
    }

    @GetMapping("/edit/{id}")
    public String getFloor(@PathVariable("id") Long id, Model model) {
        Floor floor = floorService.getById(id);
        model.addAttribute("floor", floor);
        model.addAttribute("campuses", campusService.getAll());
        return "editFloor";
    }

    @PostMapping("/edit/{id}")
    public String editFloor(@ModelAttribute Floor floor) {
        floorService.update(floor);
        return "redirect:/floor";
    }
}