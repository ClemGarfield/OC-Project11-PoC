package com.medhead.poc.hospitalservice.mapper;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.model.Hospital;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HospitalMapperTest {

    @Test
    void shouldMapModelToDto() {

        Hospital hospital = Hospital.builder()
                .id(1L)
                .name("Fred Brooks Hospital")
                .latitude(51.5074)
                .longitude(-0.1278)
                .specialties(new HashSet<>())
                .build();

        HospitalDto dto = HospitalMapper.toDto(hospital);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Fred Brooks Hospital", dto.getName());
        assertEquals(51.5074, dto.getLatitude());
        assertEquals(-0.1278, dto.getLongitude());
    }

    @Test
    void shouldMapDtoToModel() {

        HospitalDto dto = HospitalDto.builder()
                .id(1L)
                .name("Fred Brooks Hospital")
                .latitude(51.5074)
                .longitude(-0.1278)
                .build();

        Hospital hospital = HospitalMapper.toModel(dto);

        assertNotNull(hospital);
        assertEquals(1L, hospital.getId());
        assertEquals("Fred Brooks Hospital", hospital.getName());
        assertEquals(51.5074, hospital.getLatitude());
        assertEquals(-0.1278, hospital.getLongitude());
    }
}