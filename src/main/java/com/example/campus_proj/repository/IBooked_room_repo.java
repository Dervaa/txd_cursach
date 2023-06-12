package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Booked_room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBooked_room_repo extends JpaRepository<Booked_room, Long> {}
