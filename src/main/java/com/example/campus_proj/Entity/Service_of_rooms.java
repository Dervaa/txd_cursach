package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "service_of_rooms")
public class Service_of_rooms {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "service_of_rooms_id")
    @Id
    private Long id;
    @Column (columnDefinition = "TEXT", name= "service_of_rooms_name")
    private String service_name;
    @Column (columnDefinition = "INTEGER", name= "service_of_rooms_cost")
    private Integer service_cost;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "booked_room_id", referencedColumnName = "booked_room_id", foreignKey = @ForeignKey(name = "fk_id_genre"))
    private Booked_room booked_room_id;

}
