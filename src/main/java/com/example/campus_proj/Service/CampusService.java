package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Campus;
import com.example.campus_proj.repository.ICampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CampusService {
    @Autowired
    ICampusRepository iCampusRepository;

    @Async
    public List<Campus> getAll() {
        return iCampusRepository.findAll();
    }
    @Async
    public Campus getById(Long id) {
        return iCampusRepository.findById(id).orElse(null);
    }
    public void create(Campus campus) {
        iCampusRepository.save(campus);
    }
    public void delete(Long id){
        iCampusRepository.deleteById(id);
    }
    public void update(Campus campus) {
        Campus campus1 = getById(campus.getId());
        campus1.setCampusClass(campus.getCampusClass());
        campus1.setCampusRooms(campus.getCampusRooms());
        campus1.setCampusFloors(campus.getCampusFloors());
        iCampusRepository.save(campus1);
    }
}
