package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest_booking")
public class GuestBookingController {
    @Autowired
    GuestBookingService guestBookingService;
    @Autowired
    GuestService guestService;
    @Autowired
    BookingService bookingService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("guestBookings", guestBookingService.getAll());
        model.addAttribute("guests", guestService.getAll());
        model.addAttribute("bookings", bookingService.getAll());
        return "guest_booking";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        GuestBooking guestBooking = guestBookingService.getById(id);
        model.addAttribute("guestBooking", guestBooking);
        return "guestBooking-details";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute GuestBooking guestBooking) {
        guestBookingService.create(guestBooking);
        return "redirect:/guest_booking";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        guestBookingService.delete(id);
        return "redirect:/guest_booking";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("guestBooking") GuestBooking guestBooking) {
        guestBookingService.update(guestBooking);
        return "redirect:/guest_booking";
    }

    @GetMapping("/edit/{id}")
    public String getGuestBooking(@PathVariable("id") Long id, Model model) {
        GuestBooking guestBooking = guestBookingService.getById(id);
        model.addAttribute("guestBooking", guestBooking);
        model.addAttribute("guests", guestService.getAll());
        model.addAttribute("bookings", bookingService.getAll());
        return "editGuestBooking";
    }
    @PostMapping("/edit/{id}")
    public String editGuestBooking(@ModelAttribute GuestBooking guestBooking) {
        guestBookingService.update(guestBooking);
        return "redirect:/guest_booking";
    }
}
