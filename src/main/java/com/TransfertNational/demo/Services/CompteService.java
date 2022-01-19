package com.TransfertNational.demo.Services;

import com.TransfertNational.demo.Shared.dto.ClientDto;
import com.TransfertNational.demo.Shared.dto.CompteDto;

import java.util.List;

public interface CompteService {

    CompteDto createCompte(CompteDto compte);
    CompteDto getCompteByNumCompte (String numCompte);
    CompteDto getCompteByCompteId (String compteId);
    List<CompteDto> getAllComptes(String search);
    void deleteCompteByNumCompte(String numCompte);
    void deleteCompteByCompteId(String compteId);


}
