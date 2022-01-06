package com.TransfertNational.demo.Services;

import com.TransfertNational.demo.Shared.dto.ClientDto;

import java.util.List;

public interface ClientService {


    ClientDto createClient(ClientDto client);

    ClientDto getClientByEmail(String email);

    ClientDto getClientByClientId(String clientId);

    ClientDto updateClient(String id, ClientDto clientDto);

    void deleteClient(String clientId);

    List<ClientDto> getClient(int page, int limit, String search, int status);
}
