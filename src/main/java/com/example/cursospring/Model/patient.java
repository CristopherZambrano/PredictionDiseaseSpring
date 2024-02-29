package com.example.cursospring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patient")
public class patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPatient")
    private Integer id;

    @Column(name = "idUser")
    private Integer idUser;

}
