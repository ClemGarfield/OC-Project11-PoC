package com.medhead.poc.hospitalservice.repository;

import com.medhead.poc.hospitalservice.model.HospitalSpecialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalSpecialtyRepository
        extends JpaRepository<HospitalSpecialty, Long> {

    List<HospitalSpecialty> findBySpecialtyId(
            Long specialtyId);

    Optional<HospitalSpecialty>
    findByHospitalIdAndSpecialtyId(
            Long hospitalId,
            Long specialtyId);
}