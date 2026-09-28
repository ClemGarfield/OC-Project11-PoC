package com.medhead.poc.bedservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BedDto {

    private Long id;
    private Long hospitalId;
    private Long specialtyId;
    private boolean available;
}