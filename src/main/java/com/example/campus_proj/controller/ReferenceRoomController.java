package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.ReferenceRoom;
import com.example.campus_proj.Service.FloorService;
import com.example.campus_proj.Service.ReferenceRoomService;
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
    public String save(@ModelAttribute("bookedRoom") ReferenceRoom referenceRoom) {
        referenceRoomService.update(referenceRoom);
        return "redirect:/reference_rooms";
    }
    @GetMapping("/edit/{id}")
    public String getRefRoom(@PathVariable("id") Long id, Model model) {
        ReferenceRoom referenceRoom = referenceRoomService.getById(id);
        model.addAttribute("referenceRoom", referenceRoom);
        model.addAttribute("floors", floorService.getAll());
        return "editBookedRoom";
    }
    @PostMapping("/edit/{id}")
    public String editRefRoom(@ModelAttribute ReferenceRoom referenceRoom) {
        referenceRoomService.update(referenceRoom);
        return "redirect:/reference_room";
    }
}
