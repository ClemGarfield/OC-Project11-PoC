package com.medhead.poc.bedservice.service;

import com.medhead.poc.bedservice.dto.BedDto;

import java.util.List;

public interface BedService {

    List<BedDto> getAllBeds();

    BedDto getBed(Long id);

    List<BedDto> getAvailableBeds();

    List<BedDto> getAvailableBedsBySpecialty(Long specialtyId);
}