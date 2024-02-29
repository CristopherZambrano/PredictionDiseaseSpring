package com.example.cursospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Saludo")
public class ControllerBasic {
    @GetMapping(path = "/saludar")
    public String saludoBienvenida(){
        return "index";
    }
}
