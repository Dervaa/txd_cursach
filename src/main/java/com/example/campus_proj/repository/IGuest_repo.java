package com.example.campus_proj.repository;

import com.example.campus_proj.Entity.Guest;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuest_repo extends JpaRepository<Guest, Long> {
}
