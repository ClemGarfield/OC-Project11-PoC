package com.medhead.poc.hospitalservice.service;

import com.medhead.poc.hospitalservice.dto.SpecialtyDto;
import com.medhead.poc.hospitalservice.mapper.SpecialtyMapper;
import com.medhead.poc.hospitalservice.repository.SpecialtyRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(
            SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<SpecialtyDto> getAllSpecialties() {
        return specialtyRepository.findAll()
                .stream()
                .map(SpecialtyMapper::toDto)
                .toList();
    }

    @Override
    public SpecialtyDto getSpecialty(Long id) {
        return specialtyRepository.findById(id)
                .map(SpecialtyMapper::toDto)
                .orElse(null);
    }
}