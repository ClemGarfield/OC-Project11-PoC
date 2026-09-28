package com.medhead.poc.hospitalservice.service;

import com.medhead.poc.hospitalservice.dto.HospitalDto;

import java.util.List;

public interface HospitalService {

    List<HospitalDto> getHospitalsBySpecialty(Long specialtyId);

}