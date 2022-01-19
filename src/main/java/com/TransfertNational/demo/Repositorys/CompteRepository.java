package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findByNumCompte(String numCompte);

    @Query(value="SELECT * FROM comptes where COMPTE_ID = :compteId ", nativeQuery=true)
    Compte findByCompteId(@Param("compteId") String compteId);

    //@Query("SELECT compte FROM Compte compte")
    @Query(value="SELECT * FROM comptes", nativeQuery=true)
    List<Compte> findAllComptes();

    @Query(value="SELECT * FROM comptes c WHERE (c.numCompte LIKE %:search% OR c.client.fullName LIKE %:search%)", nativeQuery=true)
    List<Compte> findAllComptesByCriteria(@Param("search") String search);

}
