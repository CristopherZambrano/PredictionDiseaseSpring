package com.example.cursospring.Services;

import com.example.cursospring.Model.Historial;
import com.example.cursospring.Model.patient;
import com.example.cursospring.Repository.PatientRepository;
import com.example.cursospring.Repository.RecordRepository;
import com.example.cursospring.Repository.diagnosisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cursospring.Model.Diagnosis;

import java.util.List;

@Service
public class DiagnosisService {

    @Autowired
    diagnosisRepository diagnosisRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RecordRepository recordRepository;

    @Transactional
    public void newDiagnosis(Diagnosis diagnosis){
        diagnosisRepository.save(diagnosis);
    }

    public Historial findHistory(int idPatient){
        patient pat = patientRepository.findByIdUser(idPatient);
        return recordRepository.findByIdPaciente(pat.getId());
    }

    public List<Diagnosis> listDiagnosis(int idPatient){
        return diagnosisRepository.findDiagnosisByIdPatient(idPatient);
    }
}
