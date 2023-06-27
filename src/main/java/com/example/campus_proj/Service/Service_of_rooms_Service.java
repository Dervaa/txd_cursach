package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Service_of_rooms;
import com.example.campus_proj.repository.IRoom_service_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class Service_of_rooms_Service {
    private final IRoom_service_repo roomServiceRepo;

    @Autowired
    public Service_of_rooms_Service(IRoom_service_repo roomServiceRepo) {
        this.roomServiceRepo = roomServiceRepo;
    }

    public List<Service_of_rooms> getAllServices() {
        return roomServiceRepo.findAll();
    }

    public Optional<Service_of_rooms> getById(Long id) {
        return roomServiceRepo.findById(id);
    }

    public void deleteServiceById(Long id) {
        roomServiceRepo.deleteById(id);
    }

    public void create(Service_of_rooms serviceOfRooms) {
        roomServiceRepo.save(serviceOfRooms);
    }

    public Service_of_rooms update(Service_of_rooms serviceOfRooms) {
        Optional<Service_of_rooms> optionalServiceOfRooms = getById(serviceOfRooms.getId());
        if (optionalServiceOfRooms.isPresent()) {
            Service_of_rooms existingServiceOfRooms = optionalServiceOfRooms.get();

            // Обновление данных обслуживания комнат
            existingServiceOfRooms.setService_name(serviceOfRooms.getService_name());
            existingServiceOfRooms.setService_cost(serviceOfRooms.getService_cost());
            existingServiceOfRooms.setBooked_room_id(serviceOfRooms.getBooked_room_id());

            // Сохранение обновленного объекта
            return roomServiceRepo.save(existingServiceOfRooms);
        } else {
            throw new NoSuchElementException("Service of rooms with ID " + serviceOfRooms.getId() + " does not exist.");
        }
    }
}
