package com.medhead.poc.hospitalservice.repository;

import com.medhead.poc.hospitalservice.model.Specialty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpecialtyRepositoryTest {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Test
    void shouldFindCardiology() {

        Optional<Specialty> specialty =
                specialtyRepository.findById(21L);

        assertTrue(specialty.isPresent());
        assertEquals("Cardiology", specialty.get().getName());
    }

    @Test
    void shouldReturnAllSpecialties() {

        assertFalse(specialtyRepository.findAll().isEmpty());
    }
}