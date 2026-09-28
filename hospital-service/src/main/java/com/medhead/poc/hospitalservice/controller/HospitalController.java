package com.medhead.poc.hospitalservice.controller;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}