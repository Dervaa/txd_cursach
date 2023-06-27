package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.repository.IGuestBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookingService {
    @Autowired
    IGuestBookingRepository iGuestBookingRepository;
    @Autowired
    GuestService guestService;
    @Autowired
    BookingService bookingService;
    @Async
    public List<GuestBooking> getAll(){
        return iGuestBookingRepository.findAll();
    }
    @Async
    public GuestBooking getById(Long id){
        return iGuestBookingRepository.findById(id).orElse(null);
    }
    public void create (GuestBooking guestBooking) {
        iGuestBookingRepository.save(guestBooking);
    }
    public void delete(Long id) {
        iGuestBookingRepository.deleteById(id);
    }
    public void update(GuestBooking guestBooking) {
        GuestBooking guestBooking1 = getById(guestBooking.getId());
        Guest guest = guestService.getById(guestBooking.getGuest().getId());
        Booking booking = bookingService.getById(guestBooking.getBooking().getId());
        guestBooking1.setGuest(guest);
        guestBooking1.setBooking(booking);
        iGuestBookingRepository.save(guestBooking1);
    }
}
