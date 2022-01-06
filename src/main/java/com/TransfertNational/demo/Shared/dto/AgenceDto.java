package com.TransfertNational.demo.Shared.dto;

import com.TransfertNational.demo.Entities.Agent;

import java.io.Serializable;
import java.util.List;

public class AgenceDto implements Serializable {

    private long id;
    private String adresseAgence;
    private String villeAgence;
    private String nomAgence;
    private String telephoneAgence;
    private boolean active = true;
    private List<Agent> agent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdresseAgence() {
        return adresseAgence;
    }

    public void setAdresseAgence(String adresseAgence) {
        this.adresseAgence = adresseAgence;
    }

    public String getVilleAgence() {
        return villeAgence;
    }

    public void setVilleAgence(String villeAgence) {
        this.villeAgence = villeAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getTelephoneAgence() {
        return telephoneAgence;
    }

    public void setTelephoneAgence(String telephoneAgence) {
        this.telephoneAgence = telephoneAgence;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Agent> getAgent() {
        return agent;
    }

    public void setAgent(List<Agent> agent) {
        this.agent = agent;
    }
}
