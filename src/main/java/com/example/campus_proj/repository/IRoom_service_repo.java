package com.example.campus_proj.repository;
import com.example.campus_proj.Entity.Service_of_rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
public interface IRoom_service_repo extends JpaRepository<Service_of_rooms, Integer> {
    void deleteService_of_roomsById(Long id);
    Service_of_rooms findService_of_roomsById(Long id);
}
