package com.medhead.poc.hospitalservice.service;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.mapper.HospitalMapper;
import com.medhead.poc.hospitalservice.model.HospitalSpecialty;
import com.medhead.poc.hospitalservice.repository.HospitalSpecialtyRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalSpecialtyRepository hospitalSpecialtyRepository;

    public HospitalServiceImpl(
            HospitalSpecialtyRepository hospitalSpecialtyRepository) {
        this.hospitalSpecialtyRepository = hospitalSpecialtyRepository;
    }

    @Override
    public List<HospitalDto> getHospitalsBySpecialty(Long specialtyId) {

        List<HospitalSpecialty> hospitalSpecialties =
                hospitalSpecialtyRepository.findBySpecialtyId(specialtyId);

        return hospitalSpecialties.stream()
                .map(HospitalSpecialty::getHospital)
                .distinct()
                .map(HospitalMapper::toDto)
                .toList();
    }

}