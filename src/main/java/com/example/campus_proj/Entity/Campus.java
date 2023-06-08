package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;


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
    private String campus_class;
    @Column(columnDefinition = "INTEGER", name = "campus_rooms")
    private Integer campus_rooms;
    @Column(columnDefinition = "INTEGER", name = "campus_floors")
    private Integer campus_floors;
}
