package com.example.cursospring.controller;


import com.example.cursospring.Model.Medicine;
import com.example.cursospring.Model.Respuesta;
import com.example.cursospring.Services.medicineService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class medicineController {

    @Autowired
    medicineService medServ;

    @GetMapping(path = "/listMedicine")
    public List<Medicine> listmedicine(HttpServletRequest request){
        return medServ.listMedicine();
    }


    @PostMapping(path = "/newMedicine")
    Respuesta newMedicine(HttpServletRequest request){
        Medicine med = new Medicine();
        med.setGenericName(request.getParameter("GenericName"));
        med.setTradeName(request.getParameter("TradeName"));
        med.setPresentation(request.getParameter("Presentation"));
        medServ.newMedicine(med);
        return new Respuesta(1,"Medicamento registrado", null);
    }
}
