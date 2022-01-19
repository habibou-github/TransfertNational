package com.TransfertNational.demo.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client{
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String clientId;
	
	@Column(nullable=false, length=100)
	private String fullName;
	
	@Column(length=3)
	private String titre; 	//  M. / Mme
	
	@Column(nullable=false)
	private String GSM;

	@OneToOne(mappedBy="client", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Compte comptes;
	


	
	public Compte getComptes() {
		return comptes;
	}

	public void setComptes(Compte comptes) {
		this.comptes = comptes;
	}

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

	public String getGSM() {
		return GSM;
	}

	public void setGSM(String gSM) {
		GSM = gSM;
	}
}