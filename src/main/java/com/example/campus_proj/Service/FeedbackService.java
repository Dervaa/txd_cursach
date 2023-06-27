package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    IFeedbackRepository iFeedbackRepository;
    @Autowired
    GuestService guestService;
    @Autowired
    BookedRoomsService bookedRoomsService;
    @Async
    public List<Feedback> getAll(){
        return iFeedbackRepository.findAll();
    }
    @Async
    public Feedback getById(Long id){
        return iFeedbackRepository.findById(id).orElse(null);
    }
    public void create (Feedback feedback) {
        iFeedbackRepository.save(feedback);
    }
    public void delete(Long id) {
        iFeedbackRepository.deleteById(id);
    }
    public void update(Feedback feedback) {
        Feedback feedback1 = getById(feedback.getId());
        feedback1.setType(feedback.getType());
        feedback1.setRating(feedback.getRating());
        feedback1.setText(feedback.getText());
        Guest guest = guestService.getById(feedback.getGuest().getId());
        BookedRoom bookedRoom = bookedRoomsService.getById(feedback.getBookedRoom().getId());
        feedback1.setGuest(guest);
        feedback1.setBookedRoom(bookedRoom);
        iFeedbackRepository.save(feedback1);
    }
}

