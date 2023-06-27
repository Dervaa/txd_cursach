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
@Table(name = "guest")
public class Guest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "guest_id")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "guest_last_name")
    private String lastName;
    @Column(columnDefinition = "TEXT", name = "guest_first_name")
    private String firstName;
    @Column(columnDefinition = "TEXT", name = "guest_middle_name")
    private String middleName;
    @Column(columnDefinition = "INTEGER", name = "guest_bill")
    private Integer guestBill;
    @OneToMany(mappedBy = "guest", cascade = CascadeType.REMOVE)
    private List<GuestBooking> guestBookings;
    @OneToMany(mappedBy = "guest", cascade = CascadeType.REMOVE)
    private List<Feedback> feedbacks;
}