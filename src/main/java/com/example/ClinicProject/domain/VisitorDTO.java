package com.example.ClinicProject.domain;

import lombok.Data;

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
@Table(name = "visitor_table")
public class VisitorDTO {
    @Id
    @GeneratedValue(generator = "visitor_table_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "visitor_table_id_seq", sequenceName = "visitor_table_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthdate")
    private Date birthdate;
}
