package com.example.cursospring.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int id;

    @Column(name = "idRecord")
    public int idRecord;

    @Column(name = "dateDiagnosis")
    public LocalDate dateDiagnosis;

    @Column(name = "diagnosis")
    public String diagnosis;

    @Column(name = "idDoctor")
    public int idDoctor;

    public Map<String, Object> toJson() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id", id);
        jsonMap.put("idRecord", idRecord);
        jsonMap.put("dateDiagnosis", dateDiagnosis.toString());
        jsonMap.put("diagnosis", diagnosis);
        jsonMap.put("idDoctor", idDoctor);
        return jsonMap;
    }
}
