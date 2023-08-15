package com.example.vadim.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "doctors_table")
    public class DoctorDTO {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "doctors_table_sequence", sequenceName = "doctors_table_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_table_sequence")
    private final int id;
    @NonNull
    @Column(name = "firstname")
    private final String firstname;
    @NonNull
    @Column(name = "lastname")
    private final String lastname;
    @NonNull
    @Column(name = "surname")
    private final String surname;
    @NonNull
    @Column(name = "birthdate")
    private final Date birthdate;
    @Column(name = "years_of_experience")
    private final int yearsOfExperience;
    @NonNull
    @Column(name = "academic_degree")
    private final String academicDegree;
    @NonNull
    @Column(name = "speciality")
    private final String speciality;
}