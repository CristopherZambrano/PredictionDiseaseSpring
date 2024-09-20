package com.example.cursospring.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ListaDiagnosis {

    Integer idDiagnosis;
    String Diagnostico;
    LocalDate Fecha;
    String Doctor;


}
