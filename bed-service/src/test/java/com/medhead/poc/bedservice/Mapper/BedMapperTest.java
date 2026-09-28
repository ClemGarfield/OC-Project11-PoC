package com.medhead.poc.bedservice.mapper;

import com.medhead.poc.bedservice.dto.BedDto;
import com.medhead.poc.bedservice.model.Bed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BedMapperTest {

    @Test
    void shouldMapModelToDto() {

        Bed bed = Bed.builder()
                .id(1L)
                .hospitalId(1L)
                .specialtyId(21L)
                .available(true)
                .build();

        BedDto dto = BedMapper.toDto(bed);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals(1L, dto.getHospitalId());
        assertEquals(21L, dto.getSpecialtyId());
        assertTrue(dto.isAvailable());
    }

    @Test
    void shouldMapDtoToModel() {

        BedDto dto = BedDto.builder()
                .id(1L)
                .hospitalId(1L)
                .specialtyId(21L)
                .available(true)
                .build();

        Bed bed = BedMapper.toModel(dto);

        assertNotNull(bed);
        assertEquals(1L, bed.getId());
        assertEquals(1L, bed.getHospitalId());
        assertEquals(21L, bed.getSpecialtyId());
        assertTrue(bed.isAvailable());
    }

    @Test
    void shouldReturnNullWhenModelIsNull() {

        assertNull(BedMapper.toDto(null));
    }

    @Test
    void shouldReturnNullWhenDtoIsNull() {

        assertNull(BedMapper.toModel(null));
    }
}