package com.example.cursospring.controller;

import com.example.cursospring.Model.Respuesta;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cursospring.Services.UserService;
import com.example.cursospring.Model.User;

@RestController
@RequestMapping(path = "/api")
public class DiagnosisController {

    @Autowired
    UserService userService;

    @PostMapping("/findUserDoc")
    Respuesta findPatient (HttpServletRequest request){
        String doc = request.getParameter("Documento");
        User user = userService.getUserByDoc(doc);
        if(user==null){
            return new Respuesta(2,
                    "Usuario no encontrado",
                    null);
        }else {
            return new Respuesta(1,
                    "Usuario encontrado",
                    user.toString());
        }
    }
}
