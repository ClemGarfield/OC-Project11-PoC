package com.medhead.poc.bedservice.service;

import com.medhead.poc.bedservice.dto.BedDto;
import com.medhead.poc.bedservice.mapper.BedMapper;
import com.medhead.poc.bedservice.repository.BedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    private final BedRepository bedRepository;

    public BedServiceImpl(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Override
    public List<BedDto> getAllBeds() {

        return bedRepository.findAll()
                .stream()
                .map(BedMapper::toDto)
                .toList();
    }

    @Override
    public BedDto getBed(Long id) {

        return bedRepository.findById(id)
                .map(BedMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<BedDto> getAvailableBeds() {

        return bedRepository.findByAvailableTrue()
                .stream()
                .map(BedMapper::toDto)
                .toList();
    }

    @Override
    public List<BedDto> getAvailableBedsBySpecialty(Long specialtyId) {

        return bedRepository.findBySpecialtyIdAndAvailableTrue(specialtyId)
                .stream()
                .map(BedMapper::toDto)
                .toList();
    }
}