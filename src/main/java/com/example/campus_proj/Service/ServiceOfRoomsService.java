package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.*;
import com.example.campus_proj.repository.IRoomServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfRoomsService {
    @Autowired
    IRoomServiceRepository iRoomServiceRepository;

    @Autowired
    GuestService guestService;
    @Autowired
    BookedRoomsService bookedRoomService;
    @Async
    public List<ServiceOfRooms> getAll(){
        return iRoomServiceRepository.findAll();
    }
    @Async
    public ServiceOfRooms getById(Long id){
        return iRoomServiceRepository.findById(id).orElse(null);
    }
    public void create (ServiceOfRooms serviceOfRooms) {
        iRoomServiceRepository.save(serviceOfRooms);
    }
    public void delete(Long id) {
        iRoomServiceRepository.deleteById(id);
    }
    public void update(ServiceOfRooms serviceOfRooms) {
        ServiceOfRooms serviceOfRooms1 = getById(serviceOfRooms.getId());
        serviceOfRooms1.setServiceName(serviceOfRooms.getServiceName());
        serviceOfRooms1.setServiceCost(serviceOfRooms.getServiceCost());
        BookedRoom bookedRoom = bookedRoomService.getById(serviceOfRooms.getBookedRoom().getId());
        serviceOfRooms1.setBookedRoom(bookedRoom);
        iRoomServiceRepository.save(serviceOfRooms1);
    }
}
