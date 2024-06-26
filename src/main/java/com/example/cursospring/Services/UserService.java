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
import java.util.Optional;

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
    public Optional<User> editUser(User user){
        Optional<User> user1 = userRepository.findById(user.getId());
        User us = new User();
        if(user1.isPresent()){
            us = user1.get();
            if(!user.getNombre().isEmpty()){
                us.setNombre(user.getNombre());
            }
            if(!user.getApellido().isEmpty()){
                us.setApellido(user.getApellido());
            }
            if(!user.getDireccion().isEmpty()){
                us.setDireccion(user.getDireccion());
            }
            if(!user.getEmail().isEmpty()){
                us.setEmail(user.getEmail());
            }
            if(!user.getCelular().isEmpty()){
                us.setCelular(user.getCelular());
            }
            userRepository.save(us);
        }
        return user1;
    }

    public String changePassword(int id, String password){
        Optional<User> user1 = userRepository.findById(id);
        if(user1.isPresent()){
            User us = user1.get();
            if (!password.isEmpty()) {
                us.setPassword(password);
                userRepository.save(us);
                return "Succesfully";
            }
            else {
                return "Error";
            }
        }
        else{
            return "Error";
        }
    }

    public Optional<doctor> findDoctor(int id){
        return doctorRepository.findById(id);
    }

    public doctor findDoctorforUser(int id){
        return doctorRepository.findByIdUser(id);
    }

    public User findByUserforDoctor(int id){
        return userRepository.findUserById(id);
    }

    public Optional<User> getUserByDoc(String document){
        return userRepository.findByDocumentAndIsPatient(document);
    }

    public int verifyUserService (int id){
        patient pat = patientRepository.findByIdUser(id);
        if(pat==null){
            doctor doc = doctorRepository.findByIdUser(id);
            if (doc==null){
                return 0;
            }
            else {
                return 2;
            }
        }
        else {
            return 1;
        }
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
