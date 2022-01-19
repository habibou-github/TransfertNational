package com.TransfertNational.demo.Services.ServicesImpl;
import com.TransfertNational.demo.Entities.Client;
import com.TransfertNational.demo.Entities.Compte;
import com.TransfertNational.demo.Repositorys.ClientRepository;
import com.TransfertNational.demo.Repositorys.CompteRepository;
import com.TransfertNational.demo.Services.ClientService;
import com.TransfertNational.demo.Shared.Utils;
import com.TransfertNational.demo.Shared.dto.ClientDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    Utils util;

    @Override
    public ClientDto createClient(ClientDto client) {
        Client checkClient = clientRepository.findByFullName(client.getFullName());
        if(checkClient != null)
            throw new RuntimeException("Ce Client ( "+ client.getFullName() +" ) est déjà existe");
        Client clientEntity = new Client();
        BeanUtils.copyProperties(client,clientEntity);

        Compte compteEntity = compteRepository.findByNumCompte(client.getNumCompte());
        clientEntity.setComptes(compteEntity);

        client.setClientId(util.generateStringId(30));

        clientRepository.save(clientEntity);

        return client;
    }


    @Override
    public ClientDto getClientByClientId(String clientId) {
        Client clientEntity = clientRepository.findByClientId(clientId);
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(clientEntity,clientDto);
        return clientDto;
    }

    @Override
    public ClientDto updateClient(String clientId, ClientDto client) {
        Client clientEntity = clientRepository.findByClientId(clientId);
        if(clientEntity == null) throw new RuntimeException("Ce Client n'existe pas");

        if(client.getFullName()!= null)
            clientEntity.setFullName(client.getFullName());
        if(client.getGSM()!= null)
            clientEntity.setGSM(client.getGSM());
        if(client.getTitre()!= null)
            clientEntity.setTitre(client.getTitre());

        Client clientUpdated = clientRepository.save(clientEntity);
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(clientUpdated,clientDto);
        return clientDto;
    }

    @Override
    public void deleteClient(String clientId) {
        Client clientEntity = clientRepository.findByClientId(clientId);
        if(clientEntity == null) throw new RuntimeException("ce Client n'existe pas");
        clientRepository.delete(clientEntity);


    }

    @Override
    public List<ClientDto> getClients(String search) {
        List<ClientDto> clientDtoList = new ArrayList<>();
        List<Client> clientList;
        if(search.isEmpty()) {
            clientList = clientRepository.findAllClients();
        }
        else {
            clientList = clientRepository.findAllClientsByCriteria(search);
        }
        for(Client clientEntity: clientList) {
            ClientDto clientDto = new ClientDto();
            BeanUtils.copyProperties(clientEntity,clientDto);

            clientDtoList.add(clientDto);
        }
        return clientDtoList;
    }
}
