package com.example.campus_proj.Entity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organisation_booking")
public class Organisation_Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "organisation_booking_id")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "organisation_id", referencedColumnName = "organisation_id", foreignKey = @ForeignKey(name = "organisation_id"))
    private Organisation organisation_id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "booking_booking_id", referencedColumnName = "booking_id", foreignKey = @ForeignKey(name = "booking_booking_id"))
    private Booking booking_id;
}

