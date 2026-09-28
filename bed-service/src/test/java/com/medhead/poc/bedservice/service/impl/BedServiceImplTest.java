package com.medhead.poc.bedservice.service;

import com.medhead.poc.bedservice.dto.BedDto;
import com.medhead.poc.bedservice.model.Bed;
import com.medhead.poc.bedservice.repository.BedRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BedServiceImplTest {

    @Mock
    private BedRepository bedRepository;

    @InjectMocks
    private BedServiceImpl bedService;

    @Test
    void shouldReturnAllBeds() {

        Bed bed = Bed.builder()
                .id(1L)
                .hospitalId(1L)
                .specialtyId(21L)
                .available(true)
                .build();

        when(bedRepository.findAll())
                .thenReturn(List.of(bed));

        List<BedDto> result = bedService.getAllBeds();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.getFirst().getId());
    }

    @Test
    void shouldReturnAvailableBeds() {

        Bed bed = Bed.builder()
                .id(1L)
                .hospitalId(1L)
                .specialtyId(21L)
                .available(true)
                .build();

        when(bedRepository.findByAvailableTrue())
                .thenReturn(List.of(bed));

        List<BedDto> result =
                bedService.getAvailableBeds();

        assertEquals(1, result.size());
        assertTrue(result.getFirst().isAvailable());
    }
}