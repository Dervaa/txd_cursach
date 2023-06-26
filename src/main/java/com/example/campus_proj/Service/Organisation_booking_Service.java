package com.example.campus_proj.Service;


import com.example.campus_proj.Entity.Organisation;
import com.example.campus_proj.Entity.Booking;
import com.example.campus_proj.Entity.Organisation_Booking;
import com.example.campus_proj.repository.IOrganisation_booking_repo;
import com.example.campus_proj.repository.IOrganisation_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
@Service
public class Organisation_booking_Service {
    private final IOrganisation_booking_repo organisationBookingRepo;

    @Autowired
    public Organisation_booking_Service(IOrganisation_booking_repo organisationBookingRepo) {
        this.organisationBookingRepo = organisationBookingRepo;
    }
    @Autowired
    private Organisation_Service organisationService;
    @Autowired
    private Booking_Service bookingService;
    @Async
    public List<Organisation_Booking> getAllFeedbacks() {
        return organisationBookingRepo.findAll();
    }

    @Async
    public Optional<Organisation_Booking> getById(Long id) {
        return organisationBookingRepo.findById(id);
    }

    public void deleteOrganisationBookingById(Long id) {
        organisationBookingRepo.deleteById(id);
    }

    public void create(Organisation_Booking organisationBooking) {
        organisationBookingRepo.save(organisationBooking);
    }
    public void update(Organisation_Booking organisationBooking) {
        Optional<Organisation_Booking> optionalOrganisationBooking = getById(organisationBooking.getId());
        Optional<Organisation> optionalOrganisation = organisationService.getByOrganisationName(organisationBooking.getOrganisation().getName());
        optionalOrganisation = organisationService.getByAmount(organisationBooking.getOrganisation().getAmount_of_people());
        Optional<Booking> optionalBooking = bookingService.getById(organisationBooking.getBooking().getId());

        Optional<Organisation> finalOptionalOrganisation = optionalOrganisation;
        optionalOrganisationBooking.ifPresent(existingOrganisationBooking -> {
            finalOptionalOrganisation.ifPresent(existingOrganisation -> {
                existingOrganisationBooking.setOrganisation(existingOrganisation);
            });

            optionalBooking.ifPresent(existingBooking -> {
                existingOrganisationBooking.setBooking(existingBooking);
            });

            organisationBookingRepo.save(existingOrganisationBooking);
        });
    }
    //надеюсь багов нет, а так закончено
}

