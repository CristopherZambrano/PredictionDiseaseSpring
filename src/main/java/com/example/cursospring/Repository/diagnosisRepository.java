package com.example.cursospring.Repository;

import com.example.cursospring.Model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface diagnosisRepository extends JpaRepository<Diagnosis, Integer> {

    @Query("select d " +
            "from User u inner join patient p on p.idUser = u.id " +
            "inner join Historial h on h.idPaciente = p.id inner join Diagnosis d on h.id = d.idRecord where u.id =:idUser")
    public List<Diagnosis> findDiagnosisByIdUser(int idUser);
}
