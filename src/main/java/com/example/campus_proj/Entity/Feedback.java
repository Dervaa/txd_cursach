package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "feedback")
public class Feedback {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "feedback_id")
    @Id
    private Long id;
    @Column(columnDefinition = "BOOLEAN", name = "feedback_type")
    private boolean type;
    @Column(columnDefinition = "INTEGER", name = "feedback_rating")
    private Integer rating;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "guest_id", referencedColumnName = "guest_id", foreignKey = @ForeignKey(name = "guest_id"))
    private Guest guest_id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "booked_room_id", referencedColumnName = "booked_room_id", foreignKey = @ForeignKey(name = "booked_room_id"))
    private Booked_room booked_room_id;
}
