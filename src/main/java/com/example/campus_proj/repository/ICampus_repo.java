package com.example.campus_proj.repository;
import com.example.campus_proj.Entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.KeyPairGenerator;

public interface ICampus_repo extends JpaRepository<Campus, Long> {
}
