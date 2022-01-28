package com.TransfertNational.demo.Services;

import com.TransfertNational.demo.Entities.Transfert;
import com.TransfertNational.demo.Shared.dto.TransfertDto;

import java.util.List;

public interface TransfertService {

    Transfert creatTransfert(TransfertDto transfertDto);
    //_______________________________________________________________________
    Transfert changeTransfertEtat(String transfertId, String newEtat);
    Transfert setDateReception(String transfertId);
    Transfert finDelai2(String transfertId);
    //_______________________________________________________________________
    Transfert getTransfertByTransfertId(String transfertId);
    List<Transfert> getAllTransfert();
    List<Transfert> getAllTransfertByEtat(String etat);




}
