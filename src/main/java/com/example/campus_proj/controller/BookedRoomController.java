package com.example.campus_proj.controller;
import com.example.campus_proj.Entity.Booked_room;
import com.example.campus_proj.Service.Booked_Rooms_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rooms")
public class BookedRoomController {
    @Autowired
    private final Booked_Rooms_Service roomsService;

    @Autowired
    public BookedRoomController(Booked_Rooms_Service bookedRoomsService) {
        this.roomsService = bookedRoomsService;
    }

    @GetMapping
    public String getAlltheBookedRooms(Model model) {
        List<Booked_room> bookedRooms = roomsService.getAllBookedRooms();
        model.addAttribute("bookedRooms", bookedRooms);
        return "rooms";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBooked_roomById(@PathVariable Long id) {
        roomsService.deleteBookedRoomById(id);
        return "redirect:/rooms";
    }
    @GetMapping("/edit/{id}")
    public String editBooked_roomById(@PathVariable Long id, Model model)
    {
        Optional<Booked_room> booked_room = roomsService.getById(id);
        model.addAttribute("booked_room", booked_room);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String editBooked_roomById(@PathVariable Long id,
                                      @RequestParam("capacity") Integer capacity,
                                      @RequestParam("cost") Integer cost,
                                      @RequestParam("occupationStatus") boolean occupation_status, Model model)
    {
        Optional<Booked_room> booked_room = roomsService.getById(id);
        model.addAttribute("booked_room", booked_room);
        return "edit";
    }
}



