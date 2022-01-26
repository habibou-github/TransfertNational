package com.TransfertNational.demo.Services;

import com.TransfertNational.demo.Shared.dto.AgenceDto;
import com.TransfertNational.demo.Shared.dto.AgentDto;

import java.util.List;

public interface AgenceService {

    AgenceDto createAgence(AgenceDto agence);

    AgenceDto getAgenceById(long id);

    AgenceDto updateAgence(long id, AgenceDto agence);

    void deleteAgence(long id);

    List<AgenceDto> getAgences(String search);
}
