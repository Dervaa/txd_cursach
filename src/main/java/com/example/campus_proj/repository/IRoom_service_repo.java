package com.example.campus_proj.repository;
import com.example.campus_proj.Entity.ServiceOfRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
public interface IRoom_service_repo extends JpaRepository<ServiceOfRooms, Long> {
/*    void deleteService_of_roomsById(Long id);
    ServiceOfRooms findService_of_roomsById(Long id);*/
}
