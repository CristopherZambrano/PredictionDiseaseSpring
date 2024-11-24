package com.example.cursospring.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "treatmentMedicine")
public class treatmentMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idTreament")
    private Integer treatment;

    @Nullable
    @Column(name = "id_medicine")
    private Integer medicine;

    @Column(name = "dose")
    private String dose;

    @Column(name = "Frequency")
    private String frequency;

    @Column(name = "startDate")
    private Date startDate;

    @Nullable
    @Column(name = "endDate")
    private Date endDate;
}
