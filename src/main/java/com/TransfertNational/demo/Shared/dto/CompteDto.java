package com.TransfertNational.demo.Shared.Dto;

import com.TransfertNational.demo.Entities.Client;

import java.io.Serializable;
import java.util.Date;

public class CompteDto implements Serializable {

    private long id;
    private String numCompte;
    private float solde;
    private Client client;
    private Date dateCreation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
