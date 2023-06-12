package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Booked_room;
import com.example.campus_proj.repository.IBooked_room_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Booked_Rooms_Service {
    private final IBooked_room_repo booked_room_repo;
    @Autowired
    public Booked_Rooms_Service(IBooked_room_repo booked_room_repo){
        this.booked_room_repo=booked_room_repo;
    }
    @Async
    public List<Booked_room> getAllBookedRooms(){
        return booked_room_repo.findAll();
    }

    @Async
    public Optional<Booked_room> getById(Long id){
        return booked_room_repo.findById(id);
    }
    public void deleteBookedRoomById(Long id) {
        booked_room_repo.deleteById(id);
    }
    public void create (Booked_room booked_room)
    {
        booked_room_repo.save(booked_room);
    }
    public void update(Booked_room booked_room) {
        Optional<Booked_room> optionalBooked_room = getById(booked_room.getId());
        optionalBooked_room.ifPresent(booked_room1 -> {
            booked_room1.setCost(booked_room.getCost());
            booked_room1.setCapacity(booked_room.getCapacity());
            booked_room1.setOccupation_status(booked_room.getOccupation_status());
        });
    }

}
