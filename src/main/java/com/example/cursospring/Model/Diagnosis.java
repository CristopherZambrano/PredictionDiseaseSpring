package com.example.cursospring.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int id;

    @Column(name = "idRecord")
    public int idRecord;

    @Column(name = "dateDiagnosis")
    public LocalDate dateDiagnosis;

    @Column(name = "diagnosis")
    public String diagnosis;

    @Column(name = "idDoctor")
    public int idDoctor;
}
