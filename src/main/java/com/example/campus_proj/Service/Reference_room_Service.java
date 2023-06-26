package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Reference_room;
import com.example.campus_proj.repository.IReference_room_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Reference_room_Service {
    private final IReference_room_repo referenceRoomRepo;

    @Autowired
    public Reference_room_Service(IReference_room_repo referenceRoomRepo) {
        this.referenceRoomRepo = referenceRoomRepo;
    }

    @Async
    public List<Reference_room> getAllReferenceRooms() {
        return referenceRoomRepo.findAll();
    }

    @Async
    public Optional<Reference_room> getById(Long id) {
        return referenceRoomRepo.findById(id);
    }

    public void deleteReferenceRoomById(Long id) {
        long count = referenceRoomRepo.count();
        if (count > 1) {
            referenceRoomRepo.deleteById(id);
        } else {
            throw new UnsupportedOperationException("Cannot delete the last instance of Reference_room.");
        }
    }

    public void create(Reference_room referenceRoom) {
        referenceRoomRepo.save(referenceRoom);
    }

    public void update(Reference_room referenceRoom) {
        Optional<Reference_room> optionalReferenceRoom = getById(referenceRoom.getId());
        optionalReferenceRoom.ifPresent(existingReferenceRoom -> {
            existingReferenceRoom.setCapacity(referenceRoom.getCapacity());
            existingReferenceRoom.setCost(referenceRoom.getCost());
            existingReferenceRoom.setFame_level(referenceRoom.getFame_level());
        });
    }
}

