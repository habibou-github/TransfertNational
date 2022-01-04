package com.TransfertNational.demo.Entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="agents")
public class Agent extends Client{
	

	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String encryptedPassword;
	
	@ManyToOne
	@JoinColumn(name="agenceId")
	private Agence agence;

	public Agent(String clientId, String fullName, String titre, String identityType, String identityNumbre,
			Boolean identityValidation, String paysEmission, String paysNationalite, String paysAdresse,
			String profession, String adresseLegale, String ville, String GSM, String email, Date dateNaissance,
			String username, String encryptedPassword,Agence agence) {
		
		super(clientId, fullName, titre, identityType, identityNumbre, identityValidation, paysEmission,
				paysNationalite, paysAdresse, profession, adresseLegale, ville, GSM, email, dateNaissance);
		
		this.username = username;
		this.encryptedPassword = encryptedPassword;
		this.agence = agence;
	}

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
