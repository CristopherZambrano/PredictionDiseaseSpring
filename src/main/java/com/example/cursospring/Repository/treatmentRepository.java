package com.example.cursospring.Repository;

import com.example.cursospring.Model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface treatmentRepository extends JpaRepository<Treatment, Integer> {
}
