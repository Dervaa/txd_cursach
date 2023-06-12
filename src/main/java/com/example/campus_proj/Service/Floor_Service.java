package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Floor;
import com.example.campus_proj.repository.IFloor_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Floor_Service {
    private final IFloor_repo floorRepo;

    @Autowired
    public Floor_Service(IFloor_repo floorRepo) {
        this.floorRepo = floorRepo;
    }

    @Async
    public List<Floor> getAllFloors() {
        return floorRepo.findAll();
    }

    @Async
    public Optional<Floor> getById(Long id) {
        return floorRepo.findById(id);
    }

    public void deleteFloorById(Long id) {
        long count = floorRepo.count();
        if (count > 1) {
            floorRepo.deleteById(id);
        } else {
            throw new UnsupportedOperationException("Cannot delete the last instance of Floor.");
        }
    }

    public void create(Floor floor) {
        floorRepo.save(floor);
    }

    public void update(Floor floor) {
        Optional<Floor> optionalFloor = getById(floor.getId());
        optionalFloor.ifPresent(existingFloor -> {
            existingFloor.setNumber(floor.getNumber());
            existingFloor.setFloor_rooms(floor.getFloor_rooms());
            existingFloor.setOccupied_amount(floor.getOccupied_amount());
        });
    }
}
