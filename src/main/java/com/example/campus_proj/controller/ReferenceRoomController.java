package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reference_room")
public class ReferenceRoomController {
    @Autowired
    ReferenceRoomService referenceRoomService;
    @Autowired
    FloorService floorService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("referenceRooms", referenceRoomService.getAll());
        model.addAttribute("floors", floorService.getAll());
        return "reference_room";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        ReferenceRoom referenceRoom = referenceRoomService.getById(id);
        model.addAttribute("referenceRoom", referenceRoom);
        return "referenceRoom-details";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ReferenceRoom referenceRoom) {
        referenceRoomService.create(referenceRoom);
        return "redirect:/reference_room";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        referenceRoomService.delete(id);
        return "redirect:/reference_room";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("referenceRoom") ReferenceRoom referenceRoom) {
        referenceRoomService.update(referenceRoom);
        return "redirect:/reference_room";
    }

    @GetMapping("/edit/{id}")
    public String getReferenceRoom(@PathVariable("id") Long id, Model model) {
        ReferenceRoom referenceRoom = referenceRoomService.getById(id);
        model.addAttribute("referenceRoom", referenceRoom);
        model.addAttribute("floors", floorService.getAll());
        return "editReferenceRoom";
    }
    @PostMapping("/edit/{id}")
    public String editReferenceRoom(@ModelAttribute ReferenceRoom referenceRoom) {
        referenceRoomService.update(referenceRoom);
        return "redirect:/reference_room";
    }
}
