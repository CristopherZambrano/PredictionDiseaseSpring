package com.example.cursospring.Repository;

import com.example.cursospring.Model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Historial, Integer> {
}
