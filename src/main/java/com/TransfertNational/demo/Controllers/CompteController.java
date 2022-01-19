package com.TransfertNational.demo.Controllers;
import com.TransfertNational.demo.Entities.Compte;
import com.TransfertNational.demo.Repositorys.ClientRepository;
import com.TransfertNational.demo.Services.CompteService;
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
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    CompteService compteService;
    @Autowired
    ClientRepository clientRepository;

    @GetMapping(path="/id/{compteId}", produces=MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Compte> getCompteByCompteId(@PathVariable String compteId) {
        CompteDto compteDto = compteService.getCompteByCompteId(compteId);
        Compte compte = new Compte();
        BeanUtils.copyProperties(compteDto, compte);
        compte.setClient(clientRepository.findByClientId(compteDto.getClientId()));
        return new ResponseEntity<Compte>(compte, HttpStatus.OK);
    }

    @GetMapping(path="/numCompte/{numCompte}", produces=MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Compte> getCompteByNumCompte(@PathVariable String numCompte) {
        CompteDto compteDto = compteService.getCompteByNumCompte(numCompte);
        Compte compte = new Compte();
        BeanUtils.copyProperties(compteDto, compte);
        return new ResponseEntity<Compte>(compte, HttpStatus.OK);
    }


    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Compte>> getAllComptes(@RequestParam(value="search", defaultValue = "") String search) {

        List<Compte> comptesEntities = new ArrayList<>();

        List<CompteDto> comptes = compteService.getAllComptes(search);

        for(CompteDto compteDto: comptes) {

            Compte compte = new Compte();
            BeanUtils.copyProperties(compteDto, compte);

            comptesEntities.add(compte);
        }

        return new ResponseEntity<List<Compte>>(comptesEntities, HttpStatus.OK);
    }

    @PostMapping(
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Compte> createCompte(@RequestBody CompteDto compteDto) throws Exception{

        if(compteDto.getNumCompte().isEmpty() || compteDto.getClientId().isEmpty()) throw new RuntimeException("vous oublier des champs obligatoire");

        compteService.createCompte(compteDto);
        Compte compte = new Compte();
        BeanUtils.copyProperties(compteDto, compte);

        return new ResponseEntity<Compte>(compte, HttpStatus.CREATED);
    }

    @DeleteMapping(path="/numCompte/{numCompte}")
    public ResponseEntity<Object> deleteCompteByNumCompte(@PathVariable String numCompte) {

        compteService.deleteCompteByNumCompte(numCompte);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path="/id/{compteId}")
    public ResponseEntity<Object> deleteCompteByCompteId(@PathVariable String compteId) {

        compteService.deleteCompteByCompteId(compteId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
