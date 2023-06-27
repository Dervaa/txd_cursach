package com.example.campus_proj.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organisation")
public class Organisation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "organisation_id")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "organisation_name")
    private String name;
    @Column(columnDefinition = "INTEGER", name = "organisation_amount_of_people")
    private Integer amountOfPeople;
    @Column(columnDefinition = "INTEGER", name = "organisation_bill")
    private Integer orgBill;
}
