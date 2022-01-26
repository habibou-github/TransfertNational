package com.TransfertNational.demo.Shared.dto;

import com.TransfertNational.demo.Entities.Agence;

import java.io.Serializable;

public class AgentDto extends ClientDto implements Serializable {

    private String username;
    private String password;
    private Long agenceId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }
}
