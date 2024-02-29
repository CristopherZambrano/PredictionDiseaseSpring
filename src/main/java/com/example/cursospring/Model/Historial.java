package com.example.cursospring.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "record")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecord")
    private Integer id;

    @Column(name = "idPatient")
    private Integer idPaciente;

    @Column(name = "dateRegister")
    private Date FechaRegistro;
}
