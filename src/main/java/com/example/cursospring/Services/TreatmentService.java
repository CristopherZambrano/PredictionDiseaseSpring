package com.example.cursospring.Services;

import com.example.cursospring.Model.Medicine;
import com.example.cursospring.Model.Treatment;
import com.example.cursospring.Model.treatmentMedicine;
import com.example.cursospring.Repository.medicineTreatmentRepository;
import com.example.cursospring.Repository.treatmentRepository;
import com.example.cursospring.Repository.medicineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TreatmentService {

    @Autowired
    treatmentRepository treatRepo;

    @Autowired
    medicineTreatmentRepository meTreatRepo;

    @Autowired
    private medicineRepository medicineRepository;

    @Transactional
    public Treatment newTreatment(Treatment treatment){
        return treatRepo.save(treatment);
    }

    @Transactional
    public void  detailTreatment (treatmentMedicine treatmentMedicine){
        meTreatRepo.save(treatmentMedicine);
    }

    public Map<String, Object> getLatestValidTreatmentWithMedicinesByUser(Integer idUser) {
        // Obtener el último tratamiento válido para el usuario
        Optional<Treatment> treatmentOpt = treatRepo.findLatestValidTreatmentByUser(idUser);

        if (treatmentOpt.isEmpty()) {
            throw new RuntimeException("No se encontraron tratamientos válidos para el usuario.");
        }

        Treatment treatment = treatmentOpt.get();

        // Obtener las medicinas relacionadas con el tratamiento
        List<treatmentMedicine> treatmentMedicines = meTreatRepo.findByTreatment(treatment.getId());

        // Mapear las medicinas con información adicional
        Map<String, Object> response = new HashMap<>();
        response.put("treatment", treatment);
        response.put("medicines", treatmentMedicines.stream().map(tm -> {
            Medicine medicine = medicineRepository.findById(tm.getMedicine()).orElse(null);
            Map<String, Object> medicineData = new HashMap<>();
            medicineData.put("medicine", medicine);
            medicineData.put("dose", tm.getDose());
            medicineData.put("frequency", tm.getFrequency());
            medicineData.put("startDate", tm.getStartDate());
            medicineData.put("endDate", tm.getEndDate());
            return medicineData;
        }).toList());

        return response;
    }

}
