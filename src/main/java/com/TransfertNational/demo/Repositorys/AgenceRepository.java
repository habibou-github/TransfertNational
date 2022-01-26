package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Agence;
import com.TransfertNational.demo.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

    //@Query(value="SELECT * FROM agents where AGENCE_ID = :agenceId ", nativeQuery=true)
    //List<Agent> getAgentsByAgenceId(@Param("agenceId") long agenceId);

    @Query(value="SELECT * FROM agences", nativeQuery=true)
    List<Agence> findAllAgences();

    @Query(value="SELECT * FROM agences WHERE adresseAgence LIKE %:search% OR villeAgence LIKE %:search% OR nomAgence LIKE %:search% OR telephoneAgence LIKE %:search%", nativeQuery=true)
    List<Agence> findAllAgencesByCriteria(@Param("search") String search);
}
