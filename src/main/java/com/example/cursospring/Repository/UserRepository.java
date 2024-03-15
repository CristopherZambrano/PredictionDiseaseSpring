package com.example.cursospring.Repository;

import com.example.cursospring.Model.User;
import jakarta.persistence.OneToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @OneToOne
    User findByEmail(String email);

    @OneToOne
    User findByDocumento(String documento);
}
