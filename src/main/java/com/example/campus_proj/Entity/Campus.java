package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "campus")
public class Campus {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "campus_id")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "campus_class")
    private String campusClass;
    @Column(columnDefinition = "INTEGER", name = "campus_rooms")
    private Integer campusRooms;
    @Column(columnDefinition = "INTEGER", name = "campus_floors")
    private Integer campusFloors;
    @OneToMany(mappedBy = "campus", cascade = CascadeType.REMOVE)
    private List<Floor> floors;
}