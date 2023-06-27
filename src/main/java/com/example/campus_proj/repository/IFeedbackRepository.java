package com.example.campus_proj.repository;
import com.example.campus_proj.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedbackRepository extends JpaRepository <Feedback, Long> {
}
