package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Transfert;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfertRepository extends PagingAndSortingRepository<Transfert, Long> {
}
