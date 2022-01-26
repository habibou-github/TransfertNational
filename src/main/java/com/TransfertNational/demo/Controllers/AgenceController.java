package com.TransfertNational.demo.Controllers;
import com.TransfertNational.demo.Entities.Agence;
import com.TransfertNational.demo.Entities.Agent;
import com.TransfertNational.demo.Repositorys.AgenceRepository;
import com.TransfertNational.demo.Services.AgenceService;
import com.TransfertNational.demo.Shared.Utils;
import com.TransfertNational.demo.Shared.dto.AgenceDto;
import com.TransfertNational.demo.Shared.dto.AgentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/agence")
public class AgenceController {

    @Autowired
    AgenceService agenceService;
    @Autowired
    AgenceRepository agenceRepository;
    @Autowired
    Utils util;


    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agence> createAgence(@RequestBody AgenceDto agenceDto) throws Exception{
        if(agenceDto.getAdresseAgence().isEmpty() || agenceDto.getNomAgence().isEmpty() ||
                agenceDto.getTelephoneAgence().isEmpty() || agenceDto.getVilleAgence().isEmpty())
            throw new RuntimeException("vous oublier des champs obligatoire");

        agenceService.createAgence(agenceDto);
        Agence agenceEntity = new Agence();
        BeanUtils.copyProperties(agenceDto,agenceEntity);

        return new ResponseEntity<Agence>(agenceEntity, HttpStatus.CREATED);
    }

    @GetMapping(path="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agence> getAgenceById(@PathVariable long id) {
        AgenceDto agenceDto = agenceService.getAgenceById(id);
        Agence agenceEntity = new Agence();
        BeanUtils.copyProperties(agenceDto, agenceEntity);

        return new ResponseEntity<Agence>(agenceEntity, HttpStatus.OK);
    }


    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Agence>> getAllAgences(@RequestParam(value="search", defaultValue = "") String search) {

        List<Agence> agenceList = new ArrayList<>();
        List<AgenceDto> agenceDtoList = agenceService.getAgences(search);

        for(AgenceDto agenceDto : agenceDtoList){
            Agence agenceEntity = new Agence();
            BeanUtils.copyProperties(agenceDto,agenceEntity);
            agenceList.add(agenceEntity);
        }

        return new ResponseEntity<List<Agence>>(agenceList, HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteAgenceById(@PathVariable long id) {
        agenceService.deleteAgence(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agence> updateAgence(@PathVariable long id, @RequestBody AgenceDto agenceDto) {
        AgenceDto agenceUpdated = agenceService.updateAgence(id,agenceDto);
        Agence agenceEntity = new Agence();
        BeanUtils.copyProperties(agenceUpdated,agenceEntity);

        return new ResponseEntity<Agence>(agenceEntity, HttpStatus.ACCEPTED);
    }

}
