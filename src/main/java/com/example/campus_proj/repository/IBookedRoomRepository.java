package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookedRoomRepository extends JpaRepository<BookedRoom, Long> {}
