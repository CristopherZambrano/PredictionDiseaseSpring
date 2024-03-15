package com.example.cursospring.Repository;


import com.example.cursospring.Model.User;
import com.example.cursospring.Model.patient;
import jakarta.persistence.OneToOne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <patient, Integer > {

    @OneToOne
    patient findByIdUser(int id);
}
