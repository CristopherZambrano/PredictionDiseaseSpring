package com.example.cursospring.Services;

import com.example.cursospring.Model.Medicine;
import com.example.cursospring.Repository.medicineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class medicineService {

    @Autowired
    medicineRepository mediRepo;

    @Transactional
    public void newMedicine(Medicine medicine){
        mediRepo.save(medicine);
    }

    public List<Medicine> listMedicine(){
        return mediRepo.findAll();
    }
}
