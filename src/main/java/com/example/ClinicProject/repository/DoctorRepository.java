package com.example.ClinicProject.repository;

import com.example.ClinicProject.domain.DoctorDTO;
import lombok.NonNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
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
        } catch (NullPointerException ex) {
            optionalDoctorDTO = Optional.empty();
        }
        session.close();
        return optionalDoctorDTO;
    }

    @Transactional
    public void createDoctor(DoctorDTO doctorDTO) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(doctorDTO);
        session.getTransaction().commit();
        session.close();
    }

    public boolean doctorIsExistInDb(@NonNull DoctorDTO doctorDTO) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<DoctorDTO> boxWithDoctorEntityFromDb = Optional.ofNullable(session.find(DoctorDTO.class, doctorDTO.getId()));
        session.close();
        return boxWithDoctorEntityFromDb.isPresent();
    }

    @Transactional
    public int deleteDoctorById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE DoctorDTO AS d SET isDeleted =: isDeleted WHERE id=: id");
        query.setParameter("isDeleted", true);
        query.setParameter("id", id);
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return status;
    }

    @Transactional
    public int reviveDoctorById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE DoctorDTO AS d SET isDeleted =: isDeleted WHERE id=: id");
        query.setParameter("isDeleted", false);
        query.setParameter("id", id);
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return status;
    }


}