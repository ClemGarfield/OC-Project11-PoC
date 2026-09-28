package com.medhead.poc.hospitalservice.service;

import com.medhead.poc.hospitalservice.dto.SpecialtyDto;

import java.util.List;

public interface SpecialtyService {

    List<SpecialtyDto> getAllSpecialties();

    SpecialtyDto getSpecialty(Long id);

}