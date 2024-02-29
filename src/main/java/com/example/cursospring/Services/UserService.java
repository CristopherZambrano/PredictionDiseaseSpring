package com.example.cursospring.Services;

import com.example.cursospring.Model.Historial;
import com.example.cursospring.Model.User;
import com.example.cursospring.Model.patient;
import com.example.cursospring.Model.doctor;
import com.example.cursospring.Model.detalleDoctor;
import com.example.cursospring.Model.Speciality;
import com.example.cursospring.Repository.PatientRepository;
import com.example.cursospring.Repository.RecordRepository;
import com.example.cursospring.Repository.UserRepository;
import com.example.cursospring.Repository.doctorRepository;
import com.example.cursospring.Repository.detalleDoctorRepository;
import com.example.cursospring.Repository.SpecialityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    doctorRepository doctorRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    detalleDoctorRepository detalleDoctorRepository;

    public User getUser(String email){
        return userRepository.findByEmail(email);
    }
    @Transactional
    public void newPatient(User us){
        Calendar cal = Calendar.getInstance();
        userRepository.save(us);
        patient pat = new patient();
        pat.setIdUser(us.getId());
        patientRepository.save(pat);
        Historial record = new Historial();
        record.setFechaRegistro(cal.getTime());
        record.setIdPaciente(pat.getId());
        recordRepository.save(record);
    }

    @Transactional
    public void newDoctor (User us, Speciality espe){
        userRepository.save(us);
        doctor doc = new doctor();
        doc.setIdUser(us.getId());
        doctorRepository.save(doc);
        specialityRepository.save(espe);
        detalleDoctor details = new detalleDoctor();
        details.setIdDoctor(doc.getId());
        details.setIdEspecialidad(espe.getId());
        detalleDoctorRepository.save(details);
    }
}
