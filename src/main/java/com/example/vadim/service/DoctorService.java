package com.example.vadim.service;

import com.example.vadim.domain.DoctorDTO;
import com.example.vadim.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Optional<DoctorDTO> getDoctorById(int id){
        return doctorRepository.getDoctorById(id);
    }
}
