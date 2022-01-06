package com.TransfertNational.demo.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agences")
public class Agence {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String adresseAgence;
	
	@Column(nullable=false)
	private String villeAgence;
	
	@Column(nullable=false, length=50)
    private String nomAgence;

	
	@Column(nullable=false)
	private String telephoneAgence;

	@Column(nullable=false)
    private boolean active = true;
	
	
	@OneToMany(mappedBy="agence", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
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
