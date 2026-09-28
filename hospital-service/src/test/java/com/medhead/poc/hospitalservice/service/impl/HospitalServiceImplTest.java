package com.medhead.poc.hospitalservice.service.impl;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.model.Hospital;
import com.medhead.poc.hospitalservice.model.HospitalSpecialty;
import com.medhead.poc.hospitalservice.repository.HospitalSpecialtyRepository;
import com.medhead.poc.hospitalservice.service.HospitalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HospitalServiceImplTest {

    @Mock
    private HospitalSpecialtyRepository hospitalSpecialtyRepository;

    @InjectMocks
    private HospitalServiceImpl hospitalService;

    @Test
    void shouldReturnHospitalsBySpecialty() {

        Hospital hospital = Hospital.builder()
                .id(1L)
                .name("Fred Brooks Hospital")
                .latitude(51.5074)
                .longitude(-0.1278)
                .specialties(Set.of())
                .build();

        HospitalSpecialty hospitalSpecialty =
                HospitalSpecialty.builder()
                        .id(1L)
                        .hospital(hospital)
                        .availableBeds(2)
                        .build();

        when(hospitalSpecialtyRepository.findBySpecialtyId(21L))
                .thenReturn(List.of(hospitalSpecialty));

        List<HospitalDto> result =
                hospitalService.getHospitalsBySpecialty(21L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(
                "Fred Brooks Hospital",
                result.getFirst().getName());
    }
}