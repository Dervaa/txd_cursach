package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Campus;
import com.example.campus_proj.Entity.Floor;
import com.example.campus_proj.repository.IFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FloorService {
    @Autowired
    IFloorRepository iFloorRepository;
    @Autowired
    CampusService campusService;
    @Async
    public List<Floor> getAll() {
        return iFloorRepository.findAll();
    }
    @Async
    public Floor getById(Long id) {
        return iFloorRepository.findById(id).orElse(null);
    }
    public void create(Floor floor) {
        iFloorRepository.save(floor);
    }
    public void delete(Long id) {
        iFloorRepository.deleteById(id);
    }
    public void update(Floor floor) {
        Floor floor1 = getById(floor.getId());
        floor1.setNumber(floor.getNumber());
        floor1.setFloorRooms(floor.getFloorRooms());
        floor1.setOccupiedAmount(floor.getOccupiedAmount());
        Campus campus = campusService.getById(floor.getCampus().getId());
        floor1.setCampus(campus);
        iFloorRepository.save(floor1);
    }
}
