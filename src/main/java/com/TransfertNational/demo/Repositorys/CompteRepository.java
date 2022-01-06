package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends PagingAndSortingRepository<Compte, Long> {

    Compte findByNumCompte(String numCompte);
    Compte findByCompteId(String compteId);

    //@Query("SELECT compte FROM Compte compte")
    @Query(value="SELECT * FROM comptes", nativeQuery=true)
    Page<Compte> findAllComptes(Pageable pageableRequest);

    @Query(value="SELECT * FROM comptes c WHERE (c.numCompte LIKE %:search% OR c.client.fullName LIKE %:search%)", nativeQuery=true)
    Page<Compte> findAllComptesByCriteria(Pageable pageableRequest, @Param("search") String search);

}
