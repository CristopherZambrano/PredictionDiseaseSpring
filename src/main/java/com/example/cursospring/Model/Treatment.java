package com.example.cursospring.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idDiagnosis")
    private Diagnosis diagnosis;

    @Column(name = "startDate")
    private Date startDate;

    @Nullable
    @Column(name = "endDate")
    private Date endDate;
}
