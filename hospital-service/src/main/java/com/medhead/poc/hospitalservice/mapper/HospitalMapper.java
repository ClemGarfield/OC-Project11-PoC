package com.medhead.poc.hospitalservice.mapper;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.model.Hospital;

public final class HospitalMapper {

    private HospitalMapper() {
    }

    public static HospitalDto toDto(Hospital model) {
        if (model == null) {
            return null;
        }

        return HospitalDto.builder()
                .id(model.getId())
                .name(model.getName())
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .specialties(
                        model.getSpecialties()
                                .stream()
                                .map(HospitalSpecialtyMapper::toDto)
                                .collect(java.util.stream.Collectors.toSet()))
                .build();
    }

    public static Hospital toModel(HospitalDto dto) {
        if (dto == null) {
            return null;
        }

        return Hospital.builder()
                .id(dto.getId())
                .name(dto.getName())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }
}