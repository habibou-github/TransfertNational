package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long>{

    Client findByEmail(String email);
    Client findByClientId(String clientId);
}
