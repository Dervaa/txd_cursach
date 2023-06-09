package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Booked_room;
import com.example.campus_proj.repository.IBooked_room_repo;
import com.example.campus_proj.repository.IRoom_service_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomsService {
    private final IBooked_room_repo booked_room_repo;
    @Autowired
    public RoomsService (IBooked_room_repo booked_room_repo){
        this.booked_room_repo=booked_room_repo;
    }
    @Async
    public List<Booked_room> getAllBookedRooms(){
        return booked_room_repo.findAll();
    }
}
