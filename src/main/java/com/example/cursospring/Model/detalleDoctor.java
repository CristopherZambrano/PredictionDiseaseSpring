package com.example.cursospring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "doctorSpeciality")
public class detalleDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalle")
    private Integer id;

    @Column(name = "idDoctor")
    private Integer idDoctor;

    @Column(name="idSpeciality")
    private Integer idEspecialidad;
}
