package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IGuest_repo extends JpaRepository<Guest, Long> {

/*    Optional<Guest> findFirstByLast_name(String last_name);

    Optional<Guest> findByFirst_name(String first_name);

    Optional<Guest> findByLastNameAndFirstNameAndMiddle_name(String last_name, String first_name, String middle_name);

    Optional<Guest> findByGuest_bill(Integer guest_bill);*/
}
