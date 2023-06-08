package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reference_room")
public class Reference_room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "reference_room_id")
    @Id
    private Long id;
    @Column(columnDefinition = "INTEGER", name = "reference_room_capacity")
    private Integer capacity;
    @Column(columnDefinition = "INTEGER", name = "reference_room_cost")
    private Integer cost;
    @Column(columnDefinition = "INTEGER", name = "reference_room_fame_level")
    private Integer fame_level;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "floor_id", referencedColumnName = "floor_id", foreignKey = @ForeignKey(name = "floor_id"))
    private Floor floor_id;
}
