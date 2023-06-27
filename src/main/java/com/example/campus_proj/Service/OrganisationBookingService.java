package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.repository.IOrganisationBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationBookingService {
    @Autowired
    IOrganisationBookingRepository iOrganisationBookingRepository;
    @Autowired
    OrganisationService organisationService;
    @Autowired
    BookingService bookingService;
    @Async
    public List<OrganisationBooking> getAll(){
        return iOrganisationBookingRepository.findAll();
    }
    @Async
    public OrganisationBooking getById(Long id){
        return iOrganisationBookingRepository.findById(id).orElse(null);
    }
    public void create (OrganisationBooking organisationBooking) {
        iOrganisationBookingRepository.save(organisationBooking);
    }
    public void delete(Long id) {
        iOrganisationBookingRepository.deleteById(id);
    }
    public void update(OrganisationBooking organisationBooking) {
        OrganisationBooking organisationBooking1 = getById(organisationBooking.getId());
        Organisation organisation = organisationService.getById(organisationBooking.getOrganisation().getId());
        Booking booking = bookingService.getById(organisationBooking.getBooking().getId());
        organisationBooking1.setOrganisation(organisation);
        organisationBooking1.setBooking(booking);
        iOrganisationBookingRepository.save(organisationBooking1);
    }
}



