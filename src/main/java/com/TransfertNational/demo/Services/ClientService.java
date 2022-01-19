package com.TransfertNational.demo.Services;

import com.TransfertNational.demo.Shared.dto.ClientDto;

import java.util.List;

public interface ClientService {


    ClientDto createClient(ClientDto client);

    ClientDto getClientByClientId(String clientId);

    ClientDto updateClient(String clientId, ClientDto clientDto);

    void deleteClient(String clientId);

    List<ClientDto> getClients(String search);
}
