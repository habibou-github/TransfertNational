package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert, Long> {
}
