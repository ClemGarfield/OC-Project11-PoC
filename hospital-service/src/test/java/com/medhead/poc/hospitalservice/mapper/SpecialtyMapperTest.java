package com.medhead.poc.hospitalservice.mapper;

import com.medhead.poc.hospitalservice.dto.SpecialtyDto;
import com.medhead.poc.hospitalservice.model.Specialty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyMapperTest {

    @Test
    void shouldMapModelToDto() {

        Specialty specialty = Specialty.builder()
                .id(21L)
                .name("Cardiology")
                .specialtyGroup("General medicine group")
                .build();

        SpecialtyDto dto = SpecialtyMapper.toDto(specialty);

        assertNotNull(dto);
        assertEquals(21L, dto.getId());
        assertEquals("Cardiology", dto.getName());
        assertEquals("General medicine group", dto.getSpecialtyGroup());
    }

    @Test
    void shouldMapDtoToModel() {

        SpecialtyDto dto = SpecialtyDto.builder()
                .id(21L)
                .name("Cardiology")
                .specialtyGroup("General medicine group")
                .build();

        Specialty model = SpecialtyMapper.toModel(dto);

        assertNotNull(model);
        assertEquals(21L, model.getId());
        assertEquals("Cardiology", model.getName());
        assertEquals("General medicine group", model.getSpecialtyGroup());
    }
}