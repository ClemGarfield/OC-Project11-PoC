package com.medhead.poc.bedservice.repository;

import com.medhead.poc.bedservice.model.Reservation;
import com.medhead.poc.bedservice.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByBedId(Long bedId);

    List<Reservation> findByStatus(ReservationStatus status);
}