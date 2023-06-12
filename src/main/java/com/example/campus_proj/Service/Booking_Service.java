package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Booking;
import com.example.campus_proj.repository.IBooking_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Booking_Service {
    private final IBooking_repo booking_repo;
    @Autowired
    public Booking_Service(IBooking_repo booking_repo){
        this.booking_repo=booking_repo;
    }
        @Async
        public List<Booking> getAllBookings(){
            return booking_repo.findAll();
        }

        @Async
        public Optional<Booking> getById(Long id){
            return booking_repo.findById(id);
        }
        public void deleteBookedRoomById(Long id) {
            booking_repo.deleteById(id);
        }
        public void create (Booking booking)
        {
            booking_repo.save(booking);
        }
    public void update(Booking booking) {
        Optional<Booking> optionalBooking = getById(booking.getId());
        optionalBooking.ifPresent(existingBooking -> {
            existingBooking.setBegin(booking.getBegin());
            existingBooking.setEnd(booking.getEnd());
            existingBooking.setBill(booking.getBill());
        });
    }

}
