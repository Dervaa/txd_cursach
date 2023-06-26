package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Guest;
import com.example.campus_proj.repository.IGuest_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Guest_Service {
    private final IGuest_repo guestRepo;

    @Autowired
    public Guest_Service(IGuest_repo guestRepo) {
        this.guestRepo = guestRepo;
    }

    @Async
    public List<Guest> getAllGuests() {
        return guestRepo.findAll();
    }

    @Async
    public Optional<Guest> getById(Long id) {
        return guestRepo.findById(id);
    }

    public void deleteGuestById(Long id) {
        long count = guestRepo.count();
        if (count > 1) {
            guestRepo.deleteById(id);
        } else {
            throw new UnsupportedOperationException("Cannot delete the last instance of Guest.");
        }
    }

    public void create(Guest guest) {
        guestRepo.save(guest);
    }

    public void update(Guest guest) {
        Optional<Guest> optionalGuest = getById(guest.getId());
        optionalGuest.ifPresent(existingGuest -> {
            existingGuest.setLast_name(guest.getLast_name());
            existingGuest.setFirst_name(guest.getFirst_name());
            existingGuest.setMiddle_name(guest.getMiddle_name());
            existingGuest.setGuest_bill(guest.getGuest_bill());
        });
    }
}
