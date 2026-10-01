package com.medhead.poc.hospitalservice.controller;

import com.medhead.poc.hospitalservice.dto.SpecialtyDto;
import com.medhead.poc.hospitalservice.service.SpecialtyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(
            SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping("/specialties")
    public List<SpecialtyDto> getSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/specialties/{id}")
    public SpecialtyDto getSpecialty(
            @PathVariable Long id) {

        return specialtyService.getSpecialty(id);
    }
}