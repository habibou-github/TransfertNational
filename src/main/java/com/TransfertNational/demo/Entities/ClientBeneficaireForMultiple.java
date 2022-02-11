package com.TransfertNational.demo.Entities;

import com.opencsv.bean.CsvBindByName;

public class ClientBeneficaireForMultiple{

    @CsvBindByName
    private String fullName;

    @CsvBindByName
    private String titre; 	//  M. / Mme

    @CsvBindByName
    private String GSM;

    @CsvBindByName
    private String numCompte;

    public ClientBeneficaireForMultiple(String fullName, String titre, String GSM, String numCompte) {
        this.fullName = fullName;
        this.titre = titre;
        this.GSM = GSM;
        this.numCompte = numCompte;
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

    public String getGSM() {
        return GSM;
    }

    public void setGSM(String GSM) {
        this.GSM = GSM;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }
}
