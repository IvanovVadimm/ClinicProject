package com.example.ClinicProject.service;

import com.example.ClinicProject.domain.DoctorDTO;
import com.example.ClinicProject.repository.DoctorRepository;
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

    public Optional<DoctorDTO> getDoctorById(int id) {
        return doctorRepository.getDoctorById(id);
    }

    public void createDoctor(DoctorDTO doctorDTO) {
        doctorRepository.createDoctor(doctorDTO);
        //return doctorRepository.doctorIsExistInDb(doctorDTO);
    }

    public int deleteDoctorById(int id){
        return doctorRepository.deleteDoctorById(id);
    }

    public int reviveDoctorById(int id){
        return doctorRepository.reviveDoctorById(id);
    }
}
