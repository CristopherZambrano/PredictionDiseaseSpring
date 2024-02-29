package com.example.cursospring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Speciality")
@Data
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpeciality")
    private Integer id;
    @Column(name = "title")
    private String titulo;
    @Column(name = "description")
    private String descripcion;
}
