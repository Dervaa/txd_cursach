package com.example.campus_proj.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "booking")

public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "booking_id")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "booking_begin")
    private String begin;
    @Column(columnDefinition = "TEXT", name = "booking_end")
    private String end;
    @Column(columnDefinition = "INTEGER", name = "booking_bill")
    private String bill;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "organisation_id", referencedColumnName = "organisation_id", foreignKey = @ForeignKey(name = "organisation_id"))
    private Organisation organisation;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "guest_id", referencedColumnName = "guest_id", foreignKey = @ForeignKey(name = "guest_id"))
    private Guest guest;
}
