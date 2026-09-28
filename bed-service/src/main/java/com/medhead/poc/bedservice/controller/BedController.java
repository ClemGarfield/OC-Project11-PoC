package com.medhead.poc.bedservice.controller;

import com.medhead.poc.bedservice.dto.BedDto;
import com.medhead.poc.bedservice.service.BedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BedController {

    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @GetMapping("/beds")
    public List<BedDto> getBeds() {
        return bedService.getAllBeds();
    }

    @GetMapping("/beds/{id}")
    public BedDto getBed(
            @PathVariable Long id) {

        return bedService.getBed(id);
    }

    @GetMapping("/beds/available")
    public List<BedDto> getAvailableBeds() {

        return bedService.getAvailableBeds();
    }

    @GetMapping("/beds/search")
    public List<BedDto> getAvailableBedsBySpecialty(
            @RequestParam Long specialtyId) {

        return bedService.getAvailableBedsBySpecialty(specialtyId);
    }
}