package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganisationRepository extends JpaRepository<Organisation, Long> {
}
