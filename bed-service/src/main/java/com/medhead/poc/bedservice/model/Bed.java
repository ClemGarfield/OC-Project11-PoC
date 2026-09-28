package com.medhead.poc.bedservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bed")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hospitalId;

    private Long specialtyId;

    private boolean available;
}