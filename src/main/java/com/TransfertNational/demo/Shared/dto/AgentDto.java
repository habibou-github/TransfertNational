package com.TransfertNational.demo.Shared.dto;

import com.TransfertNational.demo.Entities.Agence;

import java.io.Serializable;

public class AgentDto extends ClientDto implements Serializable {

    private String username;
    private String encryptedPassword;
    private Agence agence;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
