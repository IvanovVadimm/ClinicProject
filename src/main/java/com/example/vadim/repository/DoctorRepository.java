package com.example.vadim.repository;

import com.example.vadim.domain.DoctorDTO;
import lombok.NonNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DoctorRepository {
    private final SessionFactory sessionFactory;

    public DoctorRepository() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Optional<DoctorDTO> getDoctorById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<DoctorDTO> optionalDoctorDTO;
        try {
            optionalDoctorDTO = Optional.of(session.get(DoctorDTO.class, id));
        } catch (NullPointerException ex){
            optionalDoctorDTO = Optional.empty();
        }
        session.close();
        return optionalDoctorDTO;
    }

    public boolean createDoctor(DoctorDTO doctorDTO){
        boolean doctorDtoIsSaved = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if(!doctorDtoIsSaved){
            session.save(doctorDTO);
            doctorDtoIsSaved = true;
        }
        session.close();
        return doctorDtoIsSaved;
    }

    public boolean doctorIsExistInDb(@NonNull DoctorDTO doctorDTO){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<DoctorDTO> boxWithDoctorEntityFromDb = Optional.ofNullable(session.find(DoctorDTO.class, doctorDTO.getId()));
        session.close();
        return boxWithDoctorEntityFromDb.isPresent();
    }
}