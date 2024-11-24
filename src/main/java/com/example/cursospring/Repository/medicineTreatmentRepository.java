package com.example.cursospring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cursospring.Model.treatmentMedicine;

import java.util.List;

public interface medicineTreatmentRepository extends JpaRepository<treatmentMedicine, Integer> {
    List<treatmentMedicine> findByTreatment(Integer treatmentId);
}
