package com.TransfertNational.demo.Services.ServicesImpl;
import com.TransfertNational.demo.Entities.Client;
import com.TransfertNational.demo.Repositorys.ClientRepository;
import com.TransfertNational.demo.Services.ClientService;
import com.TransfertNational.demo.Shared.dto.ClientDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto client) {
        return null;
    }

    @Override
    public ClientDto getClientByEmail(String email) {
        Client clientEntity = clientRepository.findByEmail(email);
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(clientEntity,clientDto);
        return clientDto;
    }

    @Override
    public ClientDto getClientByClientId(String clientId) {
        Client clientEntity = clientRepository.findByClientId(clientId);
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(clientEntity,clientDto);
        return clientDto;
    }

    @Override
    public ClientDto updateClient(String id, ClientDto clientDto) {
        return null;
    }

    @Override
    public void deleteClient(String clientId) {

    }

    @Override
    public List<ClientDto> getClient(int page, int limit, String search, int status) {
        return null;
    }
}
