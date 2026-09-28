package com.medhead.poc.hospitalservice.repository;

import com.medhead.poc.hospitalservice.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
