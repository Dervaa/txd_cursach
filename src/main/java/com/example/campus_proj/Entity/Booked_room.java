package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "booked_room")

public class Booked_room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "booked_room_id")
    @Id
    private Long id;
    @Column(columnDefinition = "INTEGER", name = "booked_room_capacity")
    private Integer capacity;
    @Column(columnDefinition = "INTEGER", name = "booked_room_cost")
    private Integer cost;
    @Column(columnDefinition = "INTEGER", name = "booked_room_occupation_status")
    private Integer occupation_status;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "reference_room_id", referencedColumnName = "reference_room_id", foreignKey = @ForeignKey(name = "reference_room_id"))
    private Reference_room reference_room_id;

/*    public static Long getId(Booked_room bookedRoom) { оно не нужно но пусть будет
    }*/
}
