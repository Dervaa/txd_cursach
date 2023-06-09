package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Guest_Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuest_Booking_repo extends JpaRepository<Guest_Booking, Long> {
}
