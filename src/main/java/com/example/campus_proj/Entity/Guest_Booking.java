package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "guest_booking")
public class Guest_Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "guest_booking_id")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "guest_guest_id", referencedColumnName = "guest_id", foreignKey = @ForeignKey(name = "guest_guest_id"))
    private Guest guest_id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "booking_booking_id", referencedColumnName = "booking_id", foreignKey = @ForeignKey(name = "booking_booking_id"))
    private Booking booking_id;
}
