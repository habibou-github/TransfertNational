package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long> {
}
