package com.example.campus_proj.controller;
import com.example.campus_proj.Entity.BookedRoom;
import com.example.campus_proj.Service.BookedRoomsService;
import com.example.campus_proj.Service.ReferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booked_rooms")
public class BookedRoomController {
    @Autowired
    BookedRoomsService bookedRoomsService;
    @Autowired
    ReferenceRoomService referenceRoomService;
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("bookedRooms", bookedRoomsService.getAll());
        model.addAttribute("referenceRooms", referenceRoomService.getAll());
        return "booked_rooms";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        BookedRoom bookedRoom = bookedRoomsService.getById(id);
        model.addAttribute("bookedRoom", bookedRoom);
        return "bookedRoom-details";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute BookedRoom bookedRoom) {
        bookedRoomsService.create(bookedRoom);
        return "redirect:/booked_rooms";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookedRoomsService.delete(id);
        return "redirect:/booked_rooms";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("bookedRoom") BookedRoom bookedRoom) {
        bookedRoomsService.update(bookedRoom);
        return "redirect:/booked_rooms";
    }
    @GetMapping("/edit/{id}")
    public String getBookedRoom(@PathVariable("id") Long id, Model model) {
        BookedRoom bookedRoom = bookedRoomsService.getById(id);
        model.addAttribute("bookedRoom", bookedRoom);
        model.addAttribute("referenceRooms", referenceRoomService.getAll());
        return "editBookedRoom";
    }
    @PostMapping("/edit/{id}")
    public String editBookedRoom(@ModelAttribute BookedRoom bookedRoom) {
        bookedRoomsService.update(bookedRoom);
        return "redirect:/booked_rooms";
    }
}