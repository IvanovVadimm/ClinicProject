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

@Data
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "hospital_table")
public class HospitalDTO {
    @Id
    @GeneratedValue(generator = "hospital_table_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "hospital_table_id_seq", sequenceName = "hospital_table_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "address")
    private String address;
    @Column(name = "hospital_name")
    private String  hospital_name;
    @Column(name = "employers_sum")
    private int employers_sum;
    @Column(name = "satisfaction")
    private double satisfaction;
}