package com.medhead.poc.hospitalservice.repository;

import com.medhead.poc.hospitalservice.model.HospitalSpecialty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class HospitalSpecialtyRepositoryTest {

    @Autowired
    private HospitalSpecialtyRepository repository;

    @Test
    void shouldFindHospitalsBySpecialtyId() {

        List<HospitalSpecialty> result =
                repository.findBySpecialtyId(21L);

        assertFalse(result.isEmpty());

        assertTrue(
                result.stream()
                        .anyMatch(h ->
                                h.getHospital()
                                        .getName()
                                        .equals("Fred Brooks Hospital")));
    }

    @Test
    void shouldReturnEmptyListForUnknownSpecialty() {

        List<HospitalSpecialty> result =
                repository.findBySpecialtyId(999L);

        assertTrue(result.isEmpty());
    }
}