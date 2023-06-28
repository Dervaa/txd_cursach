package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service_of_rooms")
public class RoomServiceController {
    @Autowired
    ServiceOfRoomsService serviceOfRoomsService;
    @Autowired
    BookedRoomsService bookedRoomsService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("serviceOfRoomss", serviceOfRoomsService.getAll());
        model.addAttribute("bookedRooms", bookedRoomsService.getAll());
        return "service_of_rooms";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        ServiceOfRooms serviceOfRooms = serviceOfRoomsService.getById(id);
        model.addAttribute("serviceOfRooms", serviceOfRooms);
        return "serviceOfRooms-details";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ServiceOfRooms serviceOfRooms) {
        serviceOfRoomsService.create(serviceOfRooms);
        return "redirect:/service_of_rooms";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        serviceOfRoomsService.delete(id);
        return "redirect:/service_of_rooms";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("serviceOfRooms") ServiceOfRooms serviceOfRooms) {
        serviceOfRoomsService.update(serviceOfRooms);
        return "redirect:/service_of_rooms";
    }

    @GetMapping("/edit/{id}")
    public String getServiceOfRooms(@PathVariable("id") Long id, Model model) {
        ServiceOfRooms serviceOfRooms = serviceOfRoomsService.getById(id);
        model.addAttribute("serviceOfRooms", serviceOfRooms);
        model.addAttribute("bookedRooms", bookedRoomsService.getAll());
        return "editServiceOfRooms";
    }
    @PostMapping("/edit/{id}")
    public String editServiceOfRooms(@ModelAttribute ServiceOfRooms serviceOfRooms) {
        serviceOfRoomsService.update(serviceOfRooms);
        return "redirect:/service_of_rooms";
    }
}
