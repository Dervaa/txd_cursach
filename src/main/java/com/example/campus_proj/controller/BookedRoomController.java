package com.example.campus_proj.controller;
import com.example.campus_proj.Entity.Booked_room;
import com.example.campus_proj.Entity.Reference_room;
import com.example.campus_proj.Service.Booked_Rooms_Service;
import com.example.campus_proj.Service.Reference_room_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/booked_rooms")
public class BookedRoomController {
    @Autowired
     Booked_Rooms_Service bookedRoomsService;
    @Autowired
    Reference_room_Service referenceRoomService;

    @Autowired
    public BookedRoomController(Booked_Rooms_Service bookedRoomsService) {
        this.bookedRoomsService = bookedRoomsService;
    }

    /*@GetMapping
    public String getAlltheBookedRooms(Model model) {
        List<Booked_room> bookedRooms = bookedRoomsService.getAllBookedRooms();
        model.addAttribute("bookedRooms", bookedRooms);
        return "booked_rooms";
    }*/
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("bookedRooms", bookedRoomsService.getAllBookedRooms());
        model.addAttribute("referenceRooms", referenceRoomService.getAllReferenceRooms());
        return "booked_rooms";
    }

    @PostMapping("booked_rooms/delete/{id}")
    public String deleteBooked_roomById(@PathVariable Long id) {
        bookedRoomsService.deleteBookedRoomById(id);
        return "redirect:/booked_rooms";
    }
    @GetMapping("/edit/{id}")
    public String editBooked_roomById(@PathVariable Long id, Model model)
    {
        Optional<Booked_room> booked_room = bookedRoomsService.getById(id);
        model.addAttribute("booked_room", booked_room);
        return "booked_rooms";
    }
    @PostMapping("/edit/{id}")
    public String editBooked_roomById(@PathVariable Long id,
                                      @RequestParam("capacity") Integer capacity,
                                      @RequestParam("cost") Integer cost,
                                      @RequestParam("occupationStatus") boolean occupation_status, Model model)
    {
        Optional<Booked_room> booked_room = bookedRoomsService.getById(id);
        model.addAttribute("booked_room", booked_room);
        return "booked_rooms";
    }
}



