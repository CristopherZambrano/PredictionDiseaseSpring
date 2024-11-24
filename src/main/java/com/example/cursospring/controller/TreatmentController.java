package com.example.cursospring.controller;
import com.example.cursospring.Model.Treatment;
import com.example.cursospring.Model.treatmentMedicine;
import com.example.cursospring.Services.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class TreatmentController {

    @Autowired
    TreatmentService treatSer;

    @PostMapping(path = "/newTreatment")
    Treatment newTreatment(
            @RequestParam Integer idDiagnosis,
            @RequestParam(required = false) String fechaFin,
            @RequestParam boolean farmacologico
    )throws ParseException {
        Date currentDate = new Date();
        Treatment treatment = new Treatment();
        treatment.setDiagnosis(idDiagnosis);
        treatment.setStartDate(currentDate);
        treatment.setFarmacologico(farmacologico);
        if (fechaFin != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            treatment.setEndDate(dateFormat.parse(fechaFin));
        }
        return treatSer.newTreatment(treatment);
    }

    @PostMapping(path = "/detailTreatment")
    public void detailTreatment (@RequestParam int idTreatment,
                                 @RequestParam int idMedicine,
    @RequestParam String dosis,
                                 @RequestParam String frecuencia,
                                 @RequestParam String startDate,
                                 @RequestParam String endDate)
    throws ParseException{
        treatmentMedicine treatmed = new treatmentMedicine();
        treatmed.setTreatment(idTreatment);
        treatmed.setMedicine(idMedicine);
        treatmed.setDose(dosis);
        treatmed.setFrequency(frecuencia);
        if (startDate != null && endDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            treatmed.setStartDate(dateFormat.parse(startDate));
            treatmed.setEndDate(dateFormat.parse(endDate));
        }
        treatSer.detailTreatment(treatmed);
    }

    @PostMapping(path = "/getDetailTreatment")
    public Map<String, Object> getLatestValidTreatmentWithMedicines(@RequestParam Integer idUser) {
        return treatSer.getLatestValidTreatmentWithMedicinesByUser(idUser);
    }
}
