package com.TransfertNational.demo.Controllers;

import com.TransfertNational.demo.Entities.Client;
import com.TransfertNational.demo.Entities.Compte;
import com.TransfertNational.demo.Repositorys.CompteRepository;
import com.TransfertNational.demo.Services.ClientService;
import com.TransfertNational.demo.Services.CompteService;
import com.TransfertNational.demo.Shared.dto.ClientDto;
import com.TransfertNational.demo.Shared.dto.CompteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    CompteService compteService;
    @Autowired
    ClientService clientService;
    @Autowired
    CompteRepository compteRepository;


    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@RequestBody ClientDto clientDto) throws Exception{

        if(clientDto.getFullName().isEmpty() || clientDto.getGSM().isEmpty()) throw new RuntimeException("vous oublier des champs obligatoire");

        clientService.createClient(clientDto);
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        client.setComptes(compteRepository.findByNumCompte(clientDto.getNumCompte()));

        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    @GetMapping(path="/{clientId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClientByClientId(@PathVariable String clientId) {
        ClientDto clientDto = clientService.getClientByClientId(clientId);
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        client.setComptes(compteRepository.findByNumCompte(clientDto.getNumCompte()));
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClients(@RequestParam(value="search", defaultValue = "") String search) {

        List<Client> clientsEntities = new ArrayList<>();

        List<ClientDto> clients = clientService.getClients(search);

        for(ClientDto clientDto: clients) {

            Client client = new Client();
            BeanUtils.copyProperties(clientDto, client);
            client.setComptes(compteRepository.findByNumCompte(clientDto.getNumCompte()));
            clientsEntities.add(client);
        }

        return new ResponseEntity<List<Client>>(clientsEntities, HttpStatus.OK);
    }

    @DeleteMapping(path="/{clientId}")
    public ResponseEntity<Object> deleteCompteByCompteId(@PathVariable String clientId) {

        clientService.deleteClient(clientId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{clientId}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateUser(@PathVariable String clientId, @RequestBody ClientDto clientDto) {
        ClientDto clientUpdated = clientService.updateClient(clientId,clientDto);
        Client clientEntity = new Client();
        BeanUtils.copyProperties(clientUpdated, clientEntity);
        clientEntity.setComptes(compteRepository.findByNumCompte(clientDto.getNumCompte()));

        return new ResponseEntity<Client>(clientEntity, HttpStatus.ACCEPTED);
    }

}
