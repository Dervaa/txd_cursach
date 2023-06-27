package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Booking;
import com.example.campus_proj.Entity.Guest;
import com.example.campus_proj.Entity.Organisation;
import com.example.campus_proj.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    IBookingRepository iBookingRepository;
    @Autowired
    GuestService guestService;
    @Autowired
    OrganisationService organisationService;

    @Async
    public List<Booking> getAll(){
        return iBookingRepository.findAll();
    }
    @Async
    public Booking getById(Long id){
        return iBookingRepository.findById(id).orElse(null);
    }
    public void create (Booking booking) {
        iBookingRepository.save(booking);
    }
    public void delete(Long id) {
        iBookingRepository.deleteById(id);
    }
    public void update(Booking booking) {
        Booking booking1 = getById(booking.getId());
        booking1.setBegin(booking.getBegin());
        booking1.setEnd(booking.getEnd());
        booking1.setBill(booking.getBill());
        Organisation organisation = organisationService.getById(booking.getOrganisation().getId());
        Guest guest = guestService.getById(booking.getGuest().getId());
        booking1.setOrganisation(organisation);
        booking1.setGuest(guest);
        iBookingRepository.save(booking1);
    }
}
