package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert, Long> {

    Transfert findByTransfertId(String transfertId);
    Transfert findByReferenceTransfert(String referenceTransfert);

    @Query(value="SELECT * FROM transferts WHERE etat LIKE %:etat%", nativeQuery=true)
    List<Transfert> getAllTransfertByEtat(@Param("etat") String etat);

    @Query(value="SELECT * FROM transferts WHERE clientBeneficaireId = :clientId", nativeQuery=true)
    List<Transfert> getAllTransfertByClientBeneficaire(@Param("clientId") String clientId);

    @Query(value="SELECT * FROM transferts WHERE clientDonneurId = :clientId", nativeQuery=true)
    List<Transfert> getAllTransfertByClientDonneur(@Param("clientId") String clientId);
}
