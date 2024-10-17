package com.example.cursospring.controller;

import com.example.cursospring.Model.Respuesta;
import com.example.cursospring.Model.Treatment;
import com.example.cursospring.Model.treatmentMedicine;
import com.example.cursospring.Services.TreatmentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TreatmentController {

    TreatmentService treatSer;

    @PostMapping(path = "/newTreatment")
    Treatment newTreatment(
            @RequestParam Integer idDiagnosis,
            @RequestParam(required = false) Date fechaFin,
            @RequestParam boolean farmacologico
    ){
        Date currentDate = new Date();
        Treatment treatment = new Treatment();
        treatment.setDiagnosis(idDiagnosis);
        treatment.setStartDate(currentDate);
        treatment.setFarmacologico(farmacologico);
        return treatSer.newTreatment(treatment);
    }

    @PostMapping(path = "/detailTreatment")
    public void detailTreatment (@RequestBody List<treatmentMedicine> treatmentMedicineList){
        for(treatmentMedicine treatmentMedicine: treatmentMedicineList){
            treatSer.detailTreatment(treatmentMedicine);
        }
    }
}
