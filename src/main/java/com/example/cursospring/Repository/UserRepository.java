package com.example.cursospring.Repository;

import com.example.cursospring.Model.User;
import jakarta.persistence.OneToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @OneToOne
    User findByEmail(String email);

    @OneToOne
    User findByDocumento(String documento);

    @Query("select u from User u inner join doctor d on d.idUser = u.id where  d.id =:id")
    User findUserById(@Param("id") Integer id);

    @Query("select u from User u inner join patient p on p.idUser = u.id where u.documento= :documento")
    Optional<User> findByDocumentAndIsPatient(@Param("documento") String documento);
}
