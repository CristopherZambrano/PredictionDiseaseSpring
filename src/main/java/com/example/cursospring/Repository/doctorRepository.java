package com.example.cursospring.Repository;

import com.example.cursospring.Model.doctor;
import com.example.cursospring.Model.patient;
import jakarta.persistence.OneToOne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<doctor, Integer> {
    @OneToOne
    doctor findByIdUser(int id);
}
