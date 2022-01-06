package com.TransfertNational.demo.Shared.dto;

import com.TransfertNational.demo.Entities.Compte;

import java.io.Serializable;
import java.util.Date;

public class ClientDto implements Serializable {

    private long id;
    private String clientId;
    private String fullName;
    private String titre; 	//  M. / Mme
    private String identityType;
    private String identityNumbre;
    private Boolean identityValidation = true;
    private String paysEmission;
    private String paysNationalite;
    private String paysAdresse;
    private String profession;
    private String adresseLegale;
    private String ville;
    private String GSM;
    private String email;
    private Date dateNaissance;
    private Compte comptes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumbre() {
        return identityNumbre;
    }

    public void setIdentityNumbre(String identityNumbre) {
        this.identityNumbre = identityNumbre;
    }

    public Boolean getIdentityValidation() {
        return identityValidation;
    }

    public void setIdentityValidation(Boolean identityValidation) {
        this.identityValidation = identityValidation;
    }

    public String getPaysEmission() {
        return paysEmission;
    }

    public void setPaysEmission(String paysEmission) {
        this.paysEmission = paysEmission;
    }

    public String getPaysNationalite() {
        return paysNationalite;
    }

    public void setPaysNationalite(String paysNationalite) {
        this.paysNationalite = paysNationalite;
    }

    public String getPaysAdresse() {
        return paysAdresse;
    }

    public void setPaysAdresse(String paysAdresse) {
        this.paysAdresse = paysAdresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdresseLegale() {
        return adresseLegale;
    }

    public void setAdresseLegale(String adresseLegale) {
        this.adresseLegale = adresseLegale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getGSM() {
        return GSM;
    }

    public void setGSM(String GSM) {
        this.GSM = GSM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Compte getComptes() {
        return comptes;
    }

    public void setComptes(Compte comptes) {
        this.comptes = comptes;
    }
}
