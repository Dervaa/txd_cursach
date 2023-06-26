package com.example.campus_proj.Service;
import com.example.campus_proj.Entity.Guest;
import com.example.campus_proj.Entity.Booking;
import com.example.campus_proj.Entity.Guest_Booking;
import com.example.campus_proj.Entity.Organisation_Booking;
import com.example.campus_proj.repository.IGuest_Booking_repo;
import com.example.campus_proj.repository.IGuest_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
@Service
public class Guest_Booking_Service {
    private final IGuest_Booking_repo guestBookingRepo;

    @Autowired
    public Guest_Booking_Service(IGuest_Booking_repo guestBookingRepo){
        this.guestBookingRepo=guestBookingRepo;
    }
    @Autowired
    private Guest_Service guestService;
    @Autowired
    private Booking_Service bookingService;
    @Async
    public List<Guest_Booking> getAllFeedbacks() {
        return guestBookingRepo.findAll();
    }

    @Async
    public Optional<Guest_Booking> getById(Long id) {
        return guestBookingRepo.findById(id);
    }

    public void deleteOrganisationBookingById(Long id) {
        guestBookingRepo.deleteById(id);
    }

    public void create(Guest_Booking guestBookingo) {
        guestBookingRepo.save(guestBookingo);
    }
}
