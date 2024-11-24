package com.example.cursospring.controller;
import com.example.cursospring.Model.*;

import com.example.cursospring.Services.DiagnosisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cursospring.Services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class DiagnosisController {

    @Autowired
    UserService userService;

    @Autowired
    DiagnosisService diagnosisService;

    //Encontrar pacientes por cedula o identificacion
    @PostMapping("/findUserDoc")
    Respuesta findPatient (HttpServletRequest request){
        String doc = request.getParameter("Documento");
        Optional<User> user = userService.getUserByDoc(doc);
        if(user.isPresent()){
            User us = user.get();
            return new Respuesta(1,
                    "Usuario encontrado",
                    us.toString());
        }else {
            return new Respuesta(2,
                    "Usuario no encontrado",
                    null);
        }
    }

    //Registrar Diagnosticos
    @PostMapping("/registerDiagnosis")
    Respuesta saveDiagnosis (HttpServletRequest request){
        try {
            Diagnosis diagnosis = new Diagnosis();
            diagnosis.setDateDiagnosis(LocalDate.now());
            diagnosis.setDiagnosis(request.getParameter("diagnostico"));
            doctor docOp = userService.findDoctorforUser(Integer.parseInt(request.getParameter("idUser")));
            if(docOp != null){
                diagnosis.setIdDoctor(docOp.getId());
            }
            Historial historial=new Historial();
            historial = diagnosisService.findHistory(Integer.parseInt(request.getParameter("idPatient")));
            if(historial != null){
                diagnosis.setIdRecord(historial.getId());
                Optional<doctor> doc = userService.findDoctor(diagnosis.getIdDoctor());
                if(doc.isPresent()){
                    diagnosisService.newDiagnosis(diagnosis);
                    return new Respuesta(
                            2,
                            "Diagnostico registrado",
                            Integer.toString(diagnosis.id)
                    );
                }
                else {
                    return new Respuesta(
                            1,
                            "Doctor no registrado",
                            null
                    );
                }
            }
            else {
                return new Respuesta(
                        1,
                        "Paciente no registrado",
                        null
                );
            }

        }catch (Exception ex){
            return new Respuesta(
                    1,
                    "Error al ingresar diagnostico",
                    null
            );
        }
    }

    //@PostMapping(path = "/viewDiagnosis")


    //Encontrar doctor por id de usuario
    @PostMapping(path = "/findUserforDoctor")
    Respuesta findDoctor (HttpServletRequest request){
        User us = userService.findByUserforDoctor(Integer.parseInt(request.getParameter("idDoctor")));
        if (us==null){
            return new Respuesta(1,"Doctor no encontrado", "");
        }
        else {
            return new Respuesta(2,"Doctor encontrado", us.getNombre() + us.getApellido());
        }
    }

    //Encontrar historial por id del usuario
    @PostMapping(path = "/findHistory")
    List<ListaDiagnosis> findDiagnosis(HttpServletRequest request){
        List<ListaDiagnosis> listaDiagnoses = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Diagnosis> lista = diagnosisService.listDiagnosis(Integer.parseInt(request.getParameter("idUser")));
        if(lista.isEmpty()){
            return listaDiagnoses;
        }
        else {
            for (Diagnosis list : lista){
                ListaDiagnosis li = new ListaDiagnosis();
                User us = userService.findByUserforDoctor(list.getIdDoctor());
                li.setIdDiagnosis(list.id);
                li.setDiagnostico(list.diagnosis);
                li.setFecha(list.dateDiagnosis);
                li.setDoctor(us.getNombre()+" "+us.getApellido());
                listaDiagnoses.add(li);
            }
            return listaDiagnoses;
        }
    }
}
