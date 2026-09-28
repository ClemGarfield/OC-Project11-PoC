package com.medhead.poc.bedservice.repository;

import com.medhead.poc.bedservice.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, Long> {

    List<Bed> findByHospitalId(Long hospitalId);

    List<Bed> findBySpecialtyId(Long specialtyId);

    List<Bed> findByAvailableTrue();

    List<Bed> findBySpecialtyIdAndAvailableTrue(Long specialtyId);
}