package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Client;
import com.TransfertNational.demo.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByClientId(String clientId);
    Client findByFullName(String fullName);

    @Query(value="SELECT * FROM clients", nativeQuery=true)
    List<Client> findAllClients();

    @Query(value="SELECT * FROM clients WHERE fullName LIKE %:search%", nativeQuery=true)
    List<Client> findAllClientsByCriteria(@Param("search") String search);
}
