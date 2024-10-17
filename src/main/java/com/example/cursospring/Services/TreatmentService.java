package com.example.cursospring.Services;

import com.example.cursospring.Model.Treatment;
import com.example.cursospring.Model.treatmentMedicine;
import com.example.cursospring.Repository.medicineTreatmentRepository;
import com.example.cursospring.Repository.treatmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {

    @Autowired
    treatmentRepository treatRepo;

    @Autowired
    medicineTreatmentRepository meTreatRepo;


    @Transactional
    public Treatment newTreatment(Treatment treatment){
        return treatRepo.save(treatment);
    }

    @Transactional
    public void  detailTreatment (treatmentMedicine treatmentMedicine){
        meTreatRepo.save(treatmentMedicine);
    }

}
