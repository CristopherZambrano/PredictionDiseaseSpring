package com.example.cursospring.Repository;

import com.example.cursospring.Model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface treatmentRepository extends JpaRepository<Treatment, Integer> {

    @Query("""
           SELECT t 
           FROM Treatment t 
           JOIN Diagnosis d ON t.diagnosis = d.id 
           JOIN Historial r ON d.idRecord = r.id 
           JOIN patient p ON r.idPaciente = p.id 
           WHERE p.idUser = :idUser 
             AND (t.endDate >= CURRENT_DATE OR t.endDate IS NULL) 
           ORDER BY t.id DESC LIMIT 1
           """)
    Optional<Treatment> findLatestValidTreatmentByUser(Integer idUser);
}
