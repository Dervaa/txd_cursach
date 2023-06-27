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
@Table(name = "floor")
public class Floor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "floor_id")
    @Id
    private Long id;
    @Column(columnDefinition = "INTEGER", name = "floor_number")
    private Integer number;
    @Column(columnDefinition = "INTEGER", name = "floor_rooms")
    private Integer floorRooms;
        @Column(columnDefinition = "INTEGER", name = "floor_rooms_occupied")
    private Integer occupiedAmount;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "campus_id", referencedColumnName = "campus_id", foreignKey = @ForeignKey(name = "campus_id"))
    private Campus campus;
    @OneToMany(mappedBy = "floor", cascade = CascadeType.REMOVE)
    private List<ReferenceRoom> referenceRooms;
}
