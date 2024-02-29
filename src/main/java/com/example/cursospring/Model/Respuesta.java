package com.example.cursospring.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Respuesta {
    public Integer code;
    public String message;
    public String data;

    public Respuesta(Integer code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
