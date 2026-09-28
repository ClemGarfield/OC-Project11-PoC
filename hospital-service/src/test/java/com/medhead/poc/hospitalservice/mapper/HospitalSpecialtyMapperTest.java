package com.medhead.poc.hospitalservice.mapper;

import com.medhead.poc.hospitalservice.dto.HospitalSpecialtyDto;
import com.medhead.poc.hospitalservice.model.HospitalSpecialty;
import com.medhead.poc.hospitalservice.model.Specialty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HospitalSpecialtyMapperTest {

    @Test
    void shouldMapModelToDto() {

        Specialty specialty = Specialty.builder()
                .id(21L)
                .name("Cardiology")
                .build();

        HospitalSpecialty model = HospitalSpecialty.builder()
                .id(1L)
                .specialty(specialty)
                .availableBeds(5)
                .build();

        HospitalSpecialtyDto dto =
                HospitalSpecialtyMapper.toDto(model);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals(5, dto.getAvailableBeds());
        assertEquals(21L, dto.getSpecialty().getId());
    }

    @Test
    void shouldMapDtoToModel() {

        HospitalSpecialtyDto dto = HospitalSpecialtyDto.builder()
                .id(1L)
                .availableBeds(5)
                .build();

        HospitalSpecialty model =
                HospitalSpecialtyMapper.toModel(dto);

        assertNotNull(model);
        assertEquals(1L, model.getId());
        assertEquals(5, model.getAvailableBeds());
    }
}