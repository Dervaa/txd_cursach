package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Guest;
import com.example.campus_proj.Entity.Guest_Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGuest_Booking_repo extends JpaRepository<Guest_Booking, Long> {
    /*Optional<Guest_Booking> findFirstByLast_name(String last_name);

    Optional<Guest_Booking> findByFirst_name(String first_name);

    Optional<Guest_Booking> findByLastNameAndFirstNameAndMiddle_name(String last_name, String first_name, String middle_name);

    Optional<Guest_Booking> findByGuest_bill(Integer guest_bill);*/
}
