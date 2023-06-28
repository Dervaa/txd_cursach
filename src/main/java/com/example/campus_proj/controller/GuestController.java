package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    GuestService guestService;
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("guests", guestService.getAll());
        return "guest";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Guest guest = guestService.getById(id);
        model.addAttribute("guest", guest);
        return "guest-details";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Guest guest) {
        guestService.create(guest);
        return "redirect:/guest";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        guestService.delete(id);
        return "redirect:/guest";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("guest") Guest guest) {
        guestService.update(guest);
        return "redirect:/guest";
    }
    @GetMapping("/edit/{id}")
    public String getGuest(@PathVariable("id") Long id, Model model) {
        Guest guest = guestService.getById(id);
        model.addAttribute("guest", guest);
        return "editGuest";
    }
    @PostMapping("/edit/{id}")
    public String editGuest(@ModelAttribute Guest guest) {
        guestService.update(guest);
        return "redirect:/guest";
    }
}