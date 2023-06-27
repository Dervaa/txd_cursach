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
public class ServiceOfRooms {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "service_of_rooms_id")
    @Id
    private Long id;
    @Column (columnDefinition = "TEXT", name= "service_of_rooms_name")
    private String serviceName;
    @Column (columnDefinition = "INTEGER", name= "service_of_rooms_cost")
    private Integer serviceCost;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "booked_room_id", referencedColumnName = "booked_room_id", foreignKey = @ForeignKey(name = "booked_room_id"))
    private BookedRoom BookedRoom;
}
