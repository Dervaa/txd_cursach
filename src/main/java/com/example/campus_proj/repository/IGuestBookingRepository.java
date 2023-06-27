package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.GuestBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuestBookingRepository extends JpaRepository<GuestBooking, Long> {
}
