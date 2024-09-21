package com.example.cursospring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cursospring.Model.treatmentMedicine;

public interface medicineTreatmentRepository extends JpaRepository<treatmentMedicine, Integer> {
}
