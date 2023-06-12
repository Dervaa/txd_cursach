package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Campus;
import com.example.campus_proj.repository.ICampus_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Campus_Service {
    private final ICampus_repo campusRepo;

    @Autowired
    public Campus_Service(ICampus_repo campusRepo) {
        this.campusRepo = campusRepo;
    }

    @Async
    public List<Campus> getAllCampuses() {
        return campusRepo.findAll();
    }

    @Async
    public Optional<Campus> getById(Long id) {
        return campusRepo.findById(id);
    }

    public void deleteCampusById(Long id)
    {
        // Получить количество существующих экземпляров класса
        long count = campusRepo.count();

        // Проверить, что количество больше одного перед удалением
        if (count > 1) {
            campusRepo.deleteById(id);
        } else {
            // Если остается только один экземпляр, выбрасывается исключение
            throw new UnsupportedOperationException("Cannot delete the last instance of Campus.");
        }
    }

    public void create(Campus campus) {
        campusRepo.save(campus);
    }

    public void update(Campus campus) {
        Optional<Campus> optionalCampus = getById(campus.getId());
        optionalCampus.ifPresent(existingCampus -> {
            existingCampus.setCampus_class(campus.getCampus_class());
            existingCampus.setCampus_rooms(campus.getCampus_rooms());
            existingCampus.setCampus_floors(campus.getCampus_floors());
        });
    }
}
