package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Feedback;
import com.example.campus_proj.repository.IFeedback_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Feedback_Service {
    private final IFeedback_repo feedbackRepo;

    @Autowired
    public Feedback_Service(IFeedback_repo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    @Async
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepo.findAll();
    }

    @Async
    public Optional<Feedback> getById(Long id) {
        return feedbackRepo.findById(id);
    }

    public void deleteFeedbackById(Long id) {
            feedbackRepo.deleteById(id);
    }

    public void create(Feedback feedback) {
        feedbackRepo.save(feedback);
    }

    public void update(Feedback feedback) {
        Optional<Feedback> optionalFeedback = getById(feedback.getId());
        optionalFeedback.ifPresent(existingFeedback -> {
            existingFeedback.setType(feedback.getType());
            existingFeedback.setRating(feedback.getRating());
            existingFeedback.setText(feedback.getText());
        });
    }
}

