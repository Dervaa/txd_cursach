package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.OrganisationBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganisationBookingRepository extends JpaRepository<OrganisationBooking, Long> {
}
