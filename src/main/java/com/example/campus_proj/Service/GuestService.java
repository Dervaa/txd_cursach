package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Guest;
import com.example.campus_proj.repository.IGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestService {
    @Autowired
    IGuestRepository iGuestRepository;

    @Async
    public List<Guest> getAll(){
        return iGuestRepository.findAll();
    }
    @Async
    public Guest getById(Long id){
        return iGuestRepository.findById(id).orElse(null);
    }
    public void create (Guest guest) {
        iGuestRepository.save(guest);
    }
    public void delete(Long id) {
        iGuestRepository.deleteById(id);
    }
    public void update(Guest guest) {
        Guest guest1 = getById(guest.getId());
        guest1.setLastName(guest.getLastName());
        guest1.setFirstName(guest.getFirstName());
        guest1.setMiddleName(guest.getMiddleName());
        guest1.setGuestBill(guest.getGuestBill());
        iGuestRepository.save(guest1);
    }
}
