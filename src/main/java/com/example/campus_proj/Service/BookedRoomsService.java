package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.BookedRoom;
import com.example.campus_proj.Entity.ReferenceRoom;
import com.example.campus_proj.repository.IBookedRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookedRoomsService {
    @Autowired
    IBookedRoomRepository iBookedRoomRepository;
    @Autowired
    ReferenceRoomService referenceRoomService;
    @Async
    public List<BookedRoom> getAll(){
        return iBookedRoomRepository.findAll();
    }
    @Async
    public BookedRoom getById(Long id){
        return iBookedRoomRepository.findById(id).orElse(null);
    }
    public void create (BookedRoom bookedRoom) {
        iBookedRoomRepository.save(bookedRoom);
    }
    public void delete(Long id) {
        iBookedRoomRepository.deleteById(id);
    }
    public void update(BookedRoom bookedRoom) {
        BookedRoom bookedRoom1 = getById(bookedRoom.getId());
        bookedRoom1.setCapacity(bookedRoom.getCapacity());
        bookedRoom1.setCost(bookedRoom.getCost());
        bookedRoom1.setOccupationStatus(bookedRoom.getOccupationStatus());
        ReferenceRoom referenceRoom = referenceRoomService.getById(bookedRoom.getReferenceRoom().getId());
        bookedRoom1.setReferenceRoom(referenceRoom);
        iBookedRoomRepository.save(bookedRoom1);
    }
}
