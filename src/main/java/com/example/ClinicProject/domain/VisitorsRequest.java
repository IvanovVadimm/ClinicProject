package com.example.ClinicProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "request_table")
public class VisitorsRequest {
    @Id
    @SequenceGenerator(name = "doctors_table_sequence", sequenceName = "doctors_table_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_table_sequence")
    private int id;
    @Column(name = "date_of_request")
    private Date dateOfRequest;
    @Column(name = "content_of_request")
    private String contentOfRequest;
    @Column(name = "visitor_id")
    private int idOfVisitor;
    @Column(name = "doctor_id")
    private int idOfDoctor;
}