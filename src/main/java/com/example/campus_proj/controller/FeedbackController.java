package com.example.campus_proj.controller;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    GuestService guestService;
    @Autowired
    BookedRoomsService bookedRoomsService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("feedbacks", feedbackService.getAll());
        model.addAttribute("guests", guestService.getAll());
        model.addAttribute("bookedRooms", bookedRoomsService.getAll());
        return "feedback";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Feedback feedback = feedbackService.getById(id);
        model.addAttribute("feedback", feedback);
        return "feedback-details";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Feedback feedback) {
        feedbackService.create(feedback);
        return "redirect:/feedback";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        feedbackService.delete(id);
        return "redirect:/feedback";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("feedback") Feedback feedback) {
        feedbackService.update(feedback);
        return "redirect:/feedback";
    }

    @GetMapping("/edit/{id}")
    public String getFeedback(@PathVariable("id") Long id, Model model) {
        Feedback feedback = feedbackService.getById(id);
        model.addAttribute("feedback", feedback);
        model.addAttribute("guests", guestService.getAll());
        model.addAttribute("bookedRooms", bookedRoomsService.getAll());
        return "editFeedback";
    }

    @PostMapping("/edit/{id}")
    public String editFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.update(feedback);
        return "redirect:/feedback";
    }
}