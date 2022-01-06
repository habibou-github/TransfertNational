package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Agence;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends PagingAndSortingRepository<Agence, Long> {
}
