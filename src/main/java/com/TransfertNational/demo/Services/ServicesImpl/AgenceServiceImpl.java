package com.TransfertNational.demo.Services.ServicesImpl;

import com.TransfertNational.demo.Entities.Agence;
import com.TransfertNational.demo.Entities.Agent;
import com.TransfertNational.demo.Repositorys.AgenceRepository;
import com.TransfertNational.demo.Repositorys.AgentRepository;
import com.TransfertNational.demo.Services.AgenceService;
import com.TransfertNational.demo.Services.AgentService;
import com.TransfertNational.demo.Shared.Utils;
import com.TransfertNational.demo.Shared.dto.AgenceDto;
import com.TransfertNational.demo.Shared.dto.AgentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenceServiceImpl implements AgenceService {

    @Autowired
    AgentService agentService;
    @Autowired
    AgenceRepository agenceRepository;
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    Utils util;

    @Override
    public AgenceDto createAgence(AgenceDto agence) {

        Agence agenceEntity = new Agence();
        BeanUtils.copyProperties(agence,agenceEntity);
        if(agence.getAgents() != null){
            List<Agent> agentList = new ArrayList<>();
            for (int i = 0; i< agence.getAgents().size();i++){
                AgentDto agentDto = agence.getAgents().get(i);
                agentDto.setAgenceId(agence.getId());
                Agent agentEntity = new Agent();
                BeanUtils.copyProperties(agentDto,agentEntity);
                agentEntity.setEncryptedPassword(util.EncryptePassword(agentDto.getPassword()));
                agentEntity.setAgence(agenceRepository.findById(agentDto.getAgenceId()).orElse(null));
                agentRepository.save(agentEntity);
                agentList.add(agentEntity);
            }
            agenceEntity.setAgent(agentList);
        }

        agenceRepository.save(agenceEntity);

        return agence;
    }

    @Override
    public AgenceDto getAgenceById(long id) {

        Agence agenceEntity = agenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Cette agence n'esxiste pas"));
        AgenceDto agenceDto = new AgenceDto();
        BeanUtils.copyProperties(agenceEntity,agenceDto);
        return agenceDto;
    }

    @Override
    public AgenceDto updateAgence(long id, AgenceDto agence) {

        Agence agenceEntity = agenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Cette agence n'esxiste pas"));
        if(agence.getVilleAgence() != null)
            agenceEntity.setVilleAgence(agence.getVilleAgence());
        if(agence.getTelephoneAgence() != null)
            agenceEntity.setTelephoneAgence(agence.getTelephoneAgence());
        if(agence.getNomAgence() != null)
            agenceEntity.setNomAgence(agence.getNomAgence());
        if(agence.getAdresseAgence() != null)
            agenceEntity.setAdresseAgence(agence.getAdresseAgence());
        Agence agenceUpdated = agenceRepository.save(agenceEntity);

        return getAgenceById(agence.getId());
    }

    @Override
    public void deleteAgence(long id) {
        Agence agenceEntity = agenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Cette agence n'esxiste pas"));
        agenceRepository.delete(agenceEntity);
    }

    @Override
    public List<AgenceDto> getAgences(String search) {

        List<AgenceDto> agenceDtoList = new ArrayList<>();
        List<Agence> agenceList;
        if(search.isEmpty()){
            agenceList = agenceRepository.findAllAgences();
        }
        else {
            agenceList = agenceRepository.findAllAgencesByCriteria(search);
        }
        for(Agence agenceEntity: agenceList){
            AgenceDto agenceDto = new AgenceDto();
            BeanUtils.copyProperties(agenceEntity,agenceList);
            agenceDtoList.add(agenceDto);

        }

        return agenceDtoList;
    }
}
