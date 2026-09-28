package com.medhead.poc.hospitalservice.service.impl;

import com.medhead.poc.hospitalservice.dto.SpecialtyDto;
import com.medhead.poc.hospitalservice.model.Specialty;
import com.medhead.poc.hospitalservice.repository.SpecialtyRepository;
import com.medhead.poc.hospitalservice.service.SpecialtyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialtyServiceImplTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private SpecialtyServiceImpl specialtyService;

    @Test
    void shouldReturnAllSpecialties() {

        Specialty cardiology = Specialty.builder()
                .id(21L)
                .name("Cardiology")
                .specialtyGroup("General medicine group")
                .build();

        when(specialtyRepository.findAll())
                .thenReturn(List.of(cardiology));

        List<SpecialtyDto> result =
                specialtyService.getAllSpecialties();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Cardiology", result.getFirst().getName());
    }

    @Test
    void shouldReturnOneSpecialty() {

        Specialty cardiology = Specialty.builder()
                .id(21L)
                .name("Cardiology")
                .specialtyGroup("General medicine group")
                .build();

        when(specialtyRepository.findById(21L))
                .thenReturn(Optional.of(cardiology));

        SpecialtyDto result =
                specialtyService.getSpecialty(21L);

        assertNotNull(result);
        assertEquals(21L, result.getId());
        assertEquals("Cardiology", result.getName());
    }
}