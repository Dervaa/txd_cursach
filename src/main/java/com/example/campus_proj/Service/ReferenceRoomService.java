package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Floor;
import com.example.campus_proj.Entity.ReferenceRoom;
import com.example.campus_proj.repository.IReferenceRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReferenceRoomService {
    @Autowired
    IReferenceRoomRepository iReferenceRoomRepository;
    @Autowired
    FloorService floorService;
    @Async
    public List<ReferenceRoom> getAll(){
        return iReferenceRoomRepository.findAll();
    }
    @Async
    public ReferenceRoom getById(Long id) {
        return iReferenceRoomRepository.findById(id).orElse(null);
    }
    public void create(ReferenceRoom referenceRoom) {
        iReferenceRoomRepository.save(referenceRoom);
    }
    public void delete(Long id) {
        iReferenceRoomRepository.deleteById(id);
    }
    public void update(ReferenceRoom referenceRoom) {
        ReferenceRoom referenceRoom1 = getById(referenceRoom.getId());
        referenceRoom1.setCapacity(referenceRoom.getCapacity());
        referenceRoom1.setCost(referenceRoom.getCost());
        referenceRoom1.setFameLevel(referenceRoom.getFameLevel());
        Floor floor = floorService.getById(referenceRoom.getFloor().getId());
        referenceRoom1.setFloor(floor);
        iReferenceRoomRepository.save(referenceRoom1);
    }
}

