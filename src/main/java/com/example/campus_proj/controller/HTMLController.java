package com.example.campus_proj.controller;
import com.example.campus_proj.Entity.Booked_room;
import com.example.campus_proj.Service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HTMLController {
    @Autowired
    RoomsService roomsService;
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
    @GetMapping("/rooms")
    public String listRooms(Model model){
        List<Booked_room> bookedRooms = RoomsService.getAllBookedRooms();
        model.addAttribute("bookedRooms", bookedRooms);
        return "rooms";
    }
}

