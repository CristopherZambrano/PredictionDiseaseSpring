package com.example.cursospring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Medicine")
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedicine")
    private Integer id;

    @Column(name = "tradeName")
    private String tradeName;

    @Column(name = "genericName")
    private String genericName;

    @Column(name = "presentation")
    private String presentation;
}
