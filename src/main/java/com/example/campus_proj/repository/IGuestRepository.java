package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuestRepository extends JpaRepository<Guest, Long> {
}
