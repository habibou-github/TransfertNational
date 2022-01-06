package com.TransfertNational.demo.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comptes")
public class Compte {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false)
	private String compteId;

	@Column(nullable=false, unique=true)
	private String numCompte;
	
	@Column(nullable=false)
	private float solde;
	
	@OneToOne
	@JoinColumn(name="clientId")
	private Client client;
	

	@Column(nullable=false)
	private Date dateCreation;



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCompteId() {
		return compteId;
	}


	public void setCompteId(String compteId) {
		this.compteId = compteId;
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
