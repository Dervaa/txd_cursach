package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.Booking;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    GuestService guestService;
    @Autowired
    OrganisationService organisationService;
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("bookings", bookingService.getAll());
        model.addAttribute("guests", guestService.getAll());
        model.addAttribute("organisations", organisationService.getAll());
        return "booking";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Booking booking = bookingService.getById(id);
        model.addAttribute("booking", booking);
        return "booking-details";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Booking booking) {
        bookingService.create(booking);
        return "redirect:/booking";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return "redirect:/booking";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("booking") Booking booking) {
        bookingService.update(booking);
        return "redirect:/booking";
    }
    @GetMapping("/edit/{id}")
    public String getBooking(@PathVariable("id") Long id, Model model) {
        Booking booking = bookingService.getById(id);
        model.addAttribute("booking", booking);
        model.addAttribute("guests", guestService.getAll());
        model.addAttribute("organisations", organisationService.getAll());
        return "editBooking";
    }
    @PostMapping("/edit/{id}")
    public String editBooking(@ModelAttribute Booking booking) {
        bookingService.update(booking);
        return "redirect:/booking";
    }
}