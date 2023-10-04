package com.example.ClinicProject.controller;

import com.example.ClinicProject.domain.DoctorDTO;
import com.example.ClinicProject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable int id) {
        Optional<DoctorDTO> optionalDoctorDTO = doctorService.getDoctorById(id);
        if (!optionalDoctorDTO.isEmpty()) {
            return new ResponseEntity<>(optionalDoctorDTO.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctorById(@PathVariable int id) {
        return (doctorService.deleteDoctorById(id) != 0) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("revive/{id}")
    public ResponseEntity reviveDoctorById(@PathVariable int id) {
        return (doctorService.reviveDoctorById(id) != 0) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity registrationForDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.createDoctor(doctorDTO);
        /*Optional<DoctorDTO> dod = doctorService.getDoctorById(doctorDTO.getId()-1);
        if (dod.isPresent()){
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }*/
        return new ResponseEntity(HttpStatus.CREATED);
    }
}