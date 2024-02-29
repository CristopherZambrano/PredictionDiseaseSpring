package com.example.cursospring.Repository;

import com.example.cursospring.Model.doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<doctor, Integer> {
}
