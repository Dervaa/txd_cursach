package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "booked_room")

public class BookedRoom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "booked_room_id")
    @Id
    private Long id;
    @Column(columnDefinition = "INTEGER", name = "booked_room_capacity")
    private Integer capacity;
    @Column(columnDefinition = "INTEGER", name = "booked_room_cost")
    private Integer cost;
    @Column(columnDefinition = "INTEGER", name = "booked_room_occupation_status")
    private Integer occupationStatus;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "reference_room_id", referencedColumnName = "reference_room_id", foreignKey = @ForeignKey(name = "reference_room_id"))
    private ReferenceRoom referenceRoom;
    @OneToMany(mappedBy = "bookedRoom", cascade = CascadeType.REMOVE)
    private List<Feedback> feedbacks;
    @OneToMany(mappedBy = "bookedRoom", cascade = CascadeType.REMOVE)
    private List<ServiceOfRooms> serviceOfRooms;
}
