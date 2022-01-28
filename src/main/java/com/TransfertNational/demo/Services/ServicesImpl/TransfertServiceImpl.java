package com.TransfertNational.demo.Services.ServicesImpl;
import com.TransfertNational.demo.Entities.Transfert;
import com.TransfertNational.demo.Repositorys.ClientRepository;
import com.TransfertNational.demo.Repositorys.TransfertRepository;
import com.TransfertNational.demo.Services.TransfertService;
import com.TransfertNational.demo.Shared.Utils;
import com.TransfertNational.demo.Shared.dto.TransfertDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TransfertServiceImpl implements TransfertService {
    @Autowired
    TransfertRepository transfertRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    Utils util;

    @Override
    public Transfert creatTransfert(TransfertDto transfertDto) {
        Transfert transfertcheck = transfertRepository.findByReferenceTransfert(transfertDto.getReferenceTransfert());
        if(transfertcheck != null)
            throw new RuntimeException("Ce Transfert est déjà existe");

        Transfert transfertEntity = new Transfert();
        BeanUtils.copyProperties(transfertDto,transfertEntity);
        transfertEntity.setClientDonneur(clientRepository.findByClientId(transfertDto.getClientDonneurId()));

        transfertEntity.setClientBeneficaire(clientRepository.findByClientId(transfertDto.getClientBeneficaireId()));

        Date now = new Date(System.currentTimeMillis());
        transfertEntity.setDateTransfert(now);
        transfertEntity.setTransfertId(util.generateStringId(30));
        transfertEntity.setReferenceTransfert("837" + util.generateNumbre(10));
        if(transfertDto.getGAB_BOA())
            transfertEntity.setPin(util.generateNumbre(4));
        transfertEntity.setDelaiTransfert(7);
        transfertEntity.setEtat("A servir");

        transfertRepository.save(transfertEntity);
        return transfertEntity;
    }

    @Override
    public Transfert changeTransfertEtat(String transfertId, String newEtat) {
        Transfert transfertEntity = transfertRepository.findByTransfertId(transfertId);
        if(newEtat.equals("Débloqué") || newEtat.equals("Debloque") || newEtat.equals("DEBLOQUE") || newEtat.equals("debloque"))
            transfertEntity.setEtat("Débloqué à servir");
        if(newEtat.equals("Déshérence") || newEtat.equals("Desherence") || newEtat.equals("desherence") || newEtat.equals("DESHERENCE"))
            transfertEntity.setDelaiTransfert(2);
        transfertEntity.setEtat(newEtat);
        transfertRepository.save(transfertEntity);

        return transfertEntity;
    }



    @Override
    public Transfert setDateReception(String transfertId) {
        Transfert transfertEntity = transfertRepository.findByTransfertId(transfertId);
        Date now = new Date(System.currentTimeMillis());
        transfertEntity.setEtat("Servie");
        transfertEntity.setDateReception(now);

        return transfertEntity;
    }

    @Override
    public Transfert finDelai2(String transfertId) {
        Transfert transfertEntity = transfertRepository.findByTransfertId(transfertId);
        Date transfertDate = transfertEntity.getDateTransfert();
        Date now = new Date(System.currentTimeMillis());

        Calendar td = Calendar.getInstance();
        td.setTime(transfertDate);

        Calendar n = Calendar.getInstance();
        n.setTime(now);

        /*
        td.add(Calendar.DATE,2);
        if(transfertEntity.getDelaiTransfert() == 2 && td.after(n))
            transfertEntity.setEtat("Bloqué");

         */
        td.add(Calendar.MINUTE,1);
        if(td.before(n))
            transfertEntity.setEtat("Bloqué");
        return transfertEntity;
    }



    @Override
    public Transfert getTransfertByTransfertId(String transfertId) {
        Transfert transfertEntity = transfertRepository.findByTransfertId(transfertId);
        return transfertEntity;
    }


    @Override
    public List<Transfert> getAllTransfert() {
        List<Transfert> transfertList = transfertRepository.findAll();

        return transfertList;
    }

    @Override
    public List<Transfert> getAllTransfertByEtat(String etat) {
        List<Transfert> transfertList = transfertRepository.getAllTransfertByEtat(etat);
        return transfertList;
    }


}
