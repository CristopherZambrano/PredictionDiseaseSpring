package com.example.cursospring.Repository;


import com.example.cursospring.Model.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <patient, Integer > {
}
