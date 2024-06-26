package com.example.cursospring.controller;

import com.example.cursospring.Model.Respuesta;
import com.example.cursospring.Model.Speciality;
import com.example.cursospring.Model.User;
import com.example.cursospring.Repository.UserRepository;
import com.example.cursospring.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class LogInController {

    @Autowired
    private UserService userService;

    @SneakyThrows
    @PostMapping (path = "/registerPatient")
    public Respuesta registerPatient(HttpServletRequest request){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (checkMail(request.getParameter("email"))){
            User us = new User();
            us.setNombre(request.getParameter("name"));
            us.setApellido(request.getParameter("lastName"));
            LocalDate fecha = LocalDate.parse(request.getParameter("birthday"), formatoFecha);
            us.setFechaNacimiento(fecha);
            us.setGenero(request.getParameter("gender"));
            us.setCelular(request.getParameter("cellPhone"));
            us.setEmail(request.getParameter("email"));
            us.setPassword(request.getParameter("password"));
            us.setDireccion(request.getParameter("address"));
            us.setDocumento(request.getParameter("idNumber"));
            userService.newPatient(us);
            if(checkMail(us.getEmail())){
                return new Respuesta(
                        2,
                        "Error al ingresar el usuario",
                        null);
            }else {
                return new Respuesta(
                        1,
                        "Paciente registrado",
                        us.toString());
            }

        }
        else{
            return new Respuesta(
                    2,
                    "Email ya se encuentra en uso",
                    null);
        }
    }

    @SneakyThrows
    @PostMapping (path = "/registerDoctor")
    public Respuesta registerDoctor(HttpServletRequest request){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (checkMail(request.getParameter("email"))){
            User us = new User();
            us.setNombre(request.getParameter("name"));
            us.setApellido(request.getParameter("lastName"));
            LocalDate fecha = LocalDate.parse(request.getParameter("birthday"), formatoFecha);
            us.setFechaNacimiento(fecha);
            us.setGenero(request.getParameter("gender"));
            us.setCelular(request.getParameter("cellPhone"));
            us.setEmail(request.getParameter("email"));
            us.setPassword(request.getParameter("password"));
            us.setDireccion(request.getParameter("address"));
            us.setDocumento(request.getParameter("idNumber"));
            Speciality espe = new Speciality();
            espe.setTitulo(request.getParameter("speciality"));
            espe.setDescripcion(request.getParameter("description"));
            userService.newDoctor(us,espe);
            if(checkMail(us.getEmail())){
                return new Respuesta(
                        2,
                        "Error al ingresar el usuario",
                        null);
            }else {
                return new Respuesta(
                        1,
                        "Doctor registrado",
                        us.toString());
            }
        }
        else{
            return new Respuesta(
                    2,
                    "Email ya se encuentra en uso",
                    null);
        }
    }

    @PostMapping(path = "/finduser")
    public Respuesta logIn (HttpServletRequest request){
        User us = userService.getUser(request.getParameter("user"));
        if (us==null){
            return new Respuesta(2,
                    "Usuario no encontrado",
                    null);
        }
        else{
            if (us.getPassword().equals(request.getParameter("password"))){
                return new Respuesta(1,
                        "Usuario correcto",
                        us.toString());
            }else{
                return new Respuesta(2,
                        "Contraseña equivocada",
                        null);
            }
        }
    }

    @PostMapping("/tipeUser")
    public int verifyUser(HttpServletRequest request){
        return userService.verifyUserService(Integer.parseInt(request.getParameter("id")));
    }


    @PostMapping("/editUser")
    public Respuesta editUser(HttpServletRequest request){
        try {
            User us = new User();
            us.setId(Integer.parseInt(request.getParameter("id")));
            us.setNombre(request.getParameter("name"));
            us.setApellido(request.getParameter("lastName"));
            us.setDireccion(request.getParameter("address"));
            us.setEmail(request.getParameter("email"));
            us.setCelular(request.getParameter("cellPhone"));
            Optional<User> userOptional = userService.editUser(us);
            if (userOptional.isPresent()) {
                return new Respuesta(1, "User changed successfully", userOptional.get().toString());
            }else {
                return new Respuesta(2,"Error modifying user",null);
            }
        } catch (NumberFormatException e) {
            return new Respuesta(2,"Error modifying user",e.toString());
        }
    }

    @PostMapping("changePassword")
    public String changePassword(HttpServletRequest request){
        return userService.changePassword(Integer.parseInt(request.getParameter("id")), request.getParameter("password"));
    }

    public boolean checkMail (String email){
        User us = userService.getUser(email);
        if (us==null){
            return true;
        }
        else {
            return false;
        }
    }
}