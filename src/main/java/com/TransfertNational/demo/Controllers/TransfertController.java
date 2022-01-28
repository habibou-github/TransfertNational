package com.TransfertNational.demo.Controllers;
import com.TransfertNational.demo.Entities.Client;
import com.TransfertNational.demo.Entities.Compte;
import com.TransfertNational.demo.Entities.Transfert;
import com.TransfertNational.demo.Repositorys.ClientRepository;
import com.TransfertNational.demo.Services.TransfertService;
import com.TransfertNational.demo.Shared.dto.ClientDto;
import com.TransfertNational.demo.Shared.dto.CompteDto;
import com.TransfertNational.demo.Shared.dto.TransfertDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transfert")
public class TransfertController {

    @Autowired
    TransfertService transfertService;
    @Autowired
    ClientRepository clientRepository;

    @PostMapping(
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Transfert> createTransfert(@RequestBody TransfertDto transfertDto) throws Exception{
        if(transfertDto.getClientDonneurId().isEmpty() || transfertDto.getClientBeneficaireId().isEmpty()
            || transfertDto.getMontant()<100)
            throw new RuntimeException("vous oublier des champs obligatoire");

        Transfert transfertEntity = transfertService.creatTransfert(transfertDto);

        return new ResponseEntity<Transfert>(transfertEntity, HttpStatus.CREATED);
    }

    @PutMapping(path = "/etat/{transfertId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfert> changeTransfertEtat(@PathVariable String transfertId, @RequestBody String etat) {
        Transfert updatedTransfert = transfertService.changeTransfertEtat(transfertId,etat);

        return new ResponseEntity<Transfert>(updatedTransfert, HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/reception/{transfertId}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfert> setDateReception(@PathVariable String transfertId) {
        Transfert updatedTransfert = transfertService.setDateReception(transfertId);

        return new ResponseEntity<Transfert>(updatedTransfert, HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/finDelai/{transfertId}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfert> finDelai2(@PathVariable String transfertId) {
        Transfert updatedTransfert = transfertService.finDelai2(transfertId);

        return new ResponseEntity<Transfert>(updatedTransfert, HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/id/{transfertId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfert> getTransfertByTransfertId(@PathVariable String transfertId) {
        Transfert transfertEntity = transfertService.getTransfertByTransfertId(transfertId);

        return new ResponseEntity<Transfert>(transfertEntity, HttpStatus.OK);
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transfert>> getAllTransferts() {

        List<Transfert> transfertList = transfertService.getAllTransfert();

        return new ResponseEntity<List<Transfert>>(transfertList, HttpStatus.OK);
    }

    @GetMapping(path="/etat/{etat}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transfert>> getTransfertByetat(@PathVariable String etat) {
        List<Transfert> transfertEntityList = transfertService.getAllTransfertByEtat(etat);

        return new ResponseEntity<List<Transfert>>(transfertEntityList, HttpStatus.OK);
    }


}
