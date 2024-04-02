package com.example.cursospring.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
@Table(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer id;
    @Column(name = "name", nullable = false)
    private String nombre;
    @Column(name = "lastName", nullable = false)
    private String apellido;
    @Column(name = "email", nullable = false,length = 70)
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "birthdate", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "gender", nullable = false)
    private String genero;
    @Column(name = "address", nullable = false)
    private String direccion;
    @Column(name = "cellPhone", nullable = false)
    private String celular;
    @Column (name = "cardId", nullable = false)
    private String documento;
}
