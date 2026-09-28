package com.medhead.poc.hospitalservice.mapper;

import com.medhead.poc.hospitalservice.dto.HospitalSpecialtyDto;
import com.medhead.poc.hospitalservice.model.HospitalSpecialty;

public final class HospitalSpecialtyMapper {

    private HospitalSpecialtyMapper() {
    }

    public static HospitalSpecialtyDto toDto(HospitalSpecialty model) {
        if (model == null) {
            return null;
        }

        return HospitalSpecialtyDto.builder()
                .id(model.getId())
                .specialty(
                        SpecialtyMapper.toDto(
                                model.getSpecialty()))
                .availableBeds(model.getAvailableBeds())
                .build();
    }

    public static HospitalSpecialty toModel(
            HospitalSpecialtyDto dto) {

        if (dto == null) {
            return null;
        }

        return HospitalSpecialty.builder()
                .id(dto.getId())
                .specialty(
                        SpecialtyMapper.toModel(
                                dto.getSpecialty()))
                .availableBeds(dto.getAvailableBeds())
                .build();
    }
}