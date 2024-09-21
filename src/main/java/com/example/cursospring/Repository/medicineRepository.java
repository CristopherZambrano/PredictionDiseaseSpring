package com.example.cursospring.Repository;

import com.example.cursospring.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface medicineRepository extends JpaRepository<Medicine, Integer> {


}
