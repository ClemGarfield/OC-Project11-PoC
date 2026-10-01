package com.medhead.poc.hospitalservice.service;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.event.HospitalCapacityUpdatedEvent;
import com.medhead.poc.hospitalservice.event.HospitalCapacityUpdatedEventPublisher;
import com.medhead.poc.hospitalservice.mapper.HospitalMapper;
import com.medhead.poc.hospitalservice.model.Hospital;
import com.medhead.poc.hospitalservice.model.HospitalSpecialty;
import com.medhead.poc.hospitalservice.repository.HospitalRepository;
import com.medhead.poc.hospitalservice.repository.HospitalSpecialtyRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalSpecialtyRepository hospitalSpecialtyRepository;
    private final HospitalRepository hospitalRepository;
    private final HospitalCapacityUpdatedEventPublisher hospitalCapacityUpdatedEventPublisher;

    public HospitalServiceImpl(
            HospitalSpecialtyRepository hospitalSpecialtyRepository,
            HospitalRepository hospitalRepository,
            HospitalCapacityUpdatedEventPublisher hospitalCapacityUpdatedEventPublisher) {
        this.hospitalSpecialtyRepository = hospitalSpecialtyRepository;
        this.hospitalRepository = hospitalRepository;
        this.hospitalCapacityUpdatedEventPublisher = hospitalCapacityUpdatedEventPublisher;
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

    @Override
    public HospitalDto getHospitalById(Long id) {

        Hospital hospital = hospitalRepository
                .findById(id)
                .orElseThrow();

        return HospitalMapper.toDto(hospital);
    }

    @Override
    public void decrementCapacity(
            Long hospitalId,
            Long specialtyId) {

        HospitalSpecialty hospitalSpecialty =
                hospitalSpecialtyRepository
                        .findByHospitalIdAndSpecialtyId(
                                hospitalId,
                                specialtyId)
                        .orElseThrow();

        hospitalSpecialty.setAvailableBeds(
                hospitalSpecialty.getAvailableBeds() - 1
        );

        hospitalSpecialtyRepository.save(hospitalSpecialty);

        hospitalCapacityUpdatedEventPublisher.publish(
                new HospitalCapacityUpdatedEvent(
                        hospitalId,
                        specialtyId,
                        hospitalSpecialty.getAvailableBeds()
                )
        );
    }
}