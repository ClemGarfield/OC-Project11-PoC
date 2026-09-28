package com.medhead.poc.hospitalservice.mapper;

import com.medhead.poc.hospitalservice.dto.SpecialtyDto;
import com.medhead.poc.hospitalservice.model.Specialty;

public final class SpecialtyMapper {

    private SpecialtyMapper() {
    }

    public static SpecialtyDto toDto(Specialty model) {
        if (model == null) {
            return null;
        }

        return SpecialtyDto.builder()
                .id(model.getId())
                .name(model.getName())
                .specialtyGroup(model.getSpecialtyGroup())
                .build();
    }

    public static Specialty toModel(SpecialtyDto dto) {
        if (dto == null) {
            return null;
        }

        return Specialty.builder()
                .id(dto.getId())
                .name(dto.getName())
                .specialtyGroup(dto.getSpecialtyGroup())
                .build();
    }
}