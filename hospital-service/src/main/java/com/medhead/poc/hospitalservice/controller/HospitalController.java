package com.medhead.poc.hospitalservice.controller;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.service.HospitalService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/hospitals")
    public List<HospitalDto> getHospitals(
            @RequestParam Long specialtyId) {

        return hospitalService.getHospitalsBySpecialty(specialtyId);
    }

    @GetMapping("/hospitals/{id}")
    public HospitalDto getSpecialty(
            @PathVariable Long id) {

        return hospitalService.getHospitalById(id);
    }
}