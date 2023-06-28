package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organisation_booking")
public class OrganisationBookingController {
    @Autowired
    OrganisationBookingService organisationBookingService;
    @Autowired
    OrganisationService organisationService;
    @Autowired
    BookingService bookingService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("organisationBookings", organisationBookingService.getAll());
        model.addAttribute("organisations", organisationService.getAll());
        model.addAttribute("bookings", bookingService.getAll());
        return "organisationBookings_booking";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        OrganisationBooking organisationBooking = organisationBookingService.getById(id);
        model.addAttribute("organisationBooking", organisationBooking);
        return "organisationBooking-details";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute OrganisationBooking organisationBooking) {
        organisationBookingService.create(organisationBooking);
        return "redirect:/organisation_booking";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        organisationBookingService.delete(id);
        return "redirect:/organisation_booking";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("organisationBooking") OrganisationBooking organisationBooking) {
        organisationBookingService.update(organisationBooking);
        return "redirect:/organisation_booking";
    }

    @GetMapping("/edit/{id}")
    public String getOrganisationBooking(@PathVariable("id") Long id, Model model) {
        OrganisationBooking organisationBooking = organisationBookingService.getById(id);
        model.addAttribute("organisationBooking", organisationBooking);
        model.addAttribute("organisations", organisationService.getAll());
        model.addAttribute("bookings", bookingService.getAll());
        return "editOrganisationBooking";
    }
    @PostMapping("/edit/{id}")
    public String editOrganisationBooking(@ModelAttribute OrganisationBooking organisationBooking) {
        organisationBookingService.update(organisationBooking);
        return "redirect:/guest_booking";
    }
}