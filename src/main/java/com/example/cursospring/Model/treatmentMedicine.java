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

    @ManyToOne
    @JoinColumn(name = "idTreament")
    private Treatment treatment;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "id_medicine")
    private Medicine medicine;

    @Column(name = "dose")
    private double dose;

    @Column(name = "Frequency")
    private double frequency;

    @Column(name = "startDate")
    private Date startDate;

    @Nullable
    @Column(name = "endDate")
    private Date endDate;
}
