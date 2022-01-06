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
