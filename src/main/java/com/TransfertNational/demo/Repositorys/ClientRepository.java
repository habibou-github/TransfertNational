package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
    Client findByClientId(String clientId);
}
