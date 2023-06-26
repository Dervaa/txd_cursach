package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Booked_room;
import com.example.campus_proj.Entity.Booking;
import com.example.campus_proj.Entity.Organisation;
import com.example.campus_proj.Service.Booking_Service;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooking_repo extends JpaRepository<Booking, Long> {

}
