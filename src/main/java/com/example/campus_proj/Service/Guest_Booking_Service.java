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
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class Guest_Booking_Service {
    private final IGuest_Booking_repo guestBookingRepo;

    @Autowired
    public Guest_Booking_Service(IGuest_Booking_repo guestBookingRepo){
        this.guestBookingRepo = guestBookingRepo;
    }
    @Autowired
    private Guest_Service guestService;
    @Autowired
    private Booking_Service bookingService;
    @Async
    public List<Guest_Booking> getAllGuestBookings() {
        return guestBookingRepo.findAll();
    }

    @Async
    public Optional<Guest_Booking> getById(Long id) {
        return guestBookingRepo.findById(id);
    }

    public void deleteGuestBookingById(Long id) {
        guestBookingRepo.deleteById(id);
    }

    public void create(Guest_Booking guestBooking) {
        guestBookingRepo.save(guestBooking);
    }

    public Guest_Booking update(Guest_Booking guestBooking) {
        Optional<Guest_Booking> optionalGuestBooking = getById(guestBooking.getId());
        if (optionalGuestBooking.isPresent()) {
            Guest_Booking existingGuestBooking = optionalGuestBooking.get();

            // Обновление данных гостя
            existingGuestBooking.setGuest(guestBooking.getGuest());

            // Обновление данных бронирования
            existingGuestBooking.setBooking(guestBooking.getBooking());

            // Сохранение обновленного объекта
            return guestBookingRepo.save(existingGuestBooking);
        } else {
            throw new NoSuchElementException("Guest booking with ID " + guestBooking.getId() + " does not exist.");
        }
    }
}
