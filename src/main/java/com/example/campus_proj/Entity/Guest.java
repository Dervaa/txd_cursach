package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;


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
    private String last_name;
    @Column(columnDefinition = "TEXT", name = "guest_first_name")
    private String first_name;
    @Column(columnDefinition = "TEXT", name = "guest_middle_name")
    private String middle_name;
    @Column(columnDefinition = "INTEGER", name = "guest_bill")
    private Integer guest_bill;
}