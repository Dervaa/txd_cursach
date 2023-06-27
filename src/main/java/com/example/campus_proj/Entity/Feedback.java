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
    @Column(columnDefinition = "INTEGER", name = "feedback_type")
    private Integer type;
    @Column(columnDefinition = "INTEGER", name = "feedback_rating")
    private Integer rating;
    @Column(columnDefinition = "TEXT", name = "feedback_text")
    private String text;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "guest_id", referencedColumnName = "guest_id", foreignKey = @ForeignKey(name = "guest_id"))
    private Guest guest;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "booked_room_id", referencedColumnName = "booked_room_id", foreignKey = @ForeignKey(name = "booked_room_id"))
    private BookedRoom bookedRoom;
}
