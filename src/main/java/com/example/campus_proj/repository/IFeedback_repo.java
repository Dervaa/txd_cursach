package com.example.campus_proj.repository;
import com.example.campus_proj.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedback_repo extends JpaRepository <Feedback, Long> {
}
