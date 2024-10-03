package com.example.cursospring.Services;

import com.example.cursospring.Repository.treatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {

    @Autowired
    treatmentRepository treatRepo;

}
