package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking, Long> {}
