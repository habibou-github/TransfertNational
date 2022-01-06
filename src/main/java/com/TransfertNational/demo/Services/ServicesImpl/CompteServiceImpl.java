package com.TransfertNational.demo.Services.ServicesImpl;
import com.TransfertNational.demo.Entities.Client;
import com.TransfertNational.demo.Entities.Compte;
import com.TransfertNational.demo.Repositorys.CompteRepository;
import com.TransfertNational.demo.Services.ClientService;
import com.TransfertNational.demo.Services.CompteService;
import com.TransfertNational.demo.Shared.Utils;
import com.TransfertNational.demo.Shared.dto.ClientDto;
import com.TransfertNational.demo.Shared.dto.CompteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    CompteRepository compteRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    Utils util;

    @Override
    public CompteDto createCompte(CompteDto compte) {
        Compte checkCompte = compteRepository.findByNumCompte(compte.getNumCompte());
        if(checkCompte != null)
            throw new RuntimeException("Ce Compte ( "+ compte.getNumCompte() +" ) est déjà existe");
        Compte compteEntity = new Compte();

        //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date now = new Date(System.currentTimeMillis());
        //String d = formatter.format(now);

        BeanUtils.copyProperties(compte,compteEntity);
        compteEntity.setCompteId(util.generateStringId(30));
        compteEntity.setSolde(0);
        compteEntity.setDateCreation(now);
        Client clientEntity = new Client();
        ClientDto clientDto = clientService.getClientByClientId(compte.getClientId());
        BeanUtils.copyProperties(clientDto,clientEntity);
        compteEntity.setClient(clientEntity);
        compteRepository.save(compteEntity);

        return compte;
    }

    @Override
    public CompteDto getCompteByNumCompte(String numCompte) {

        Compte compteEntity = compteRepository.findByNumCompte(numCompte);
        CompteDto compteDto = new CompteDto();
        BeanUtils.copyProperties(compteEntity,compteDto);

        return compteDto;
    }

    @Override
    public CompteDto getCompteByCompteId(String compteId) {

        Compte compteEntity = compteRepository.findByCompteId(compteId);
        CompteDto compteDto = new CompteDto();
        BeanUtils.copyProperties(compteEntity,compteDto);
        return compteDto;
    }

    @Override
    public List<CompteDto> getAllComptes(int page, int limit, String search) {
        page-=1;
        List<CompteDto> comptesDto = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<Compte> comptePage;
        if(search.isEmpty()) {
            comptePage = compteRepository.findAllComptes(pageableRequest);
        }
        else {

            comptePage = compteRepository.findAllComptesByCriteria(pageableRequest, search);
        }
        List<Compte> comptes = comptePage.getContent();

        for(Compte compteEntity: comptes) {
            CompteDto compteDto = new CompteDto();
            BeanUtils.copyProperties(compteEntity,compteDto);

            comptesDto.add(compteDto);
        }

        return comptesDto;
    }

    @Override
    public void deleteCompteByNumCompte(String numCompte) {

        Compte compteEntity = compteRepository.findByNumCompte(numCompte);

        if(compteEntity == null) throw new RuntimeException("ce Compte n'existe pas");

        compteRepository.delete(compteEntity);
    }

    @Override
    public void deleteCompteByCompteId(String compteId) {

        Compte compteEntity = compteRepository.findByCompteId(compteId);

        if(compteEntity == null) throw new RuntimeException("ce Compte n'existe pas");

        compteRepository.delete(compteEntity);
    }

}
