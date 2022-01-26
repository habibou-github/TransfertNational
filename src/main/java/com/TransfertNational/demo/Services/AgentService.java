package com.TransfertNational.demo.Services;

import com.TransfertNational.demo.Shared.dto.AgentDto;

import java.util.List;

public interface AgentService {

    AgentDto createAgent(AgentDto agent);

    AgentDto getAgentById(long id);

    AgentDto updateAgent(long id, AgentDto agent);

    void deleteAgent(long id);

    List<AgentDto> getAgents(String search);
}
