package com.medhead.poc.bedservice.mapper;

import com.medhead.poc.bedservice.dto.BedDto;
import com.medhead.poc.bedservice.model.Bed;

public final class BedMapper {

    private BedMapper() {
    }

    public static BedDto toDto(Bed bed) {

        if (bed == null) {
            return null;
        }

        return BedDto.builder()
                .id(bed.getId())
                .hospitalId(bed.getHospitalId())
                .specialtyId(bed.getSpecialtyId())
                .available(bed.isAvailable())
                .build();
    }

    public static Bed toModel(BedDto dto) {

        if (dto == null) {
            return null;
        }

        return Bed.builder()
                .id(dto.getId())
                .hospitalId(dto.getHospitalId())
                .specialtyId(dto.getSpecialtyId())
                .available(dto.isAvailable())
                .build();
    }
}