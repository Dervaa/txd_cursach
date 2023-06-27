package com.example.campus_proj.repository;
import com.example.campus_proj.Entity.ServiceOfRooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomServiceRepository extends JpaRepository<ServiceOfRooms, Long> {
}
