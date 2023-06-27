package com.example.campus_proj.repository;
import com.example.campus_proj.Entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICampusRepository extends JpaRepository<Campus, Long> {
}
