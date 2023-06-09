package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Booked_room;
import com.example.campus_proj.Entity.Booking;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooking_repo extends JpaRepository<Booking, Long> {
}
