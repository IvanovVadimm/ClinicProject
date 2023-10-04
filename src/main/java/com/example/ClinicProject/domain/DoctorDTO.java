package com.example.ClinicProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    private int id;
    @NonNull
    @Column(name = "firstname")
    private String firstname;
    @NonNull
    @Column(name = "lastname")
    private String lastname;
    @NonNull
    @Column(name = "surname")
    private String surname;
    @NonNull
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "is_deleted")
    boolean isDeleted;
    @Column(name = "years_of_experience")
    private int yearsOfExperience;
    @NonNull
    @Column(name = "academic_degree")
    private String academicDegree;
    @NonNull
    @Column(name = "speciality")
    private String speciality;
}