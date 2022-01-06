package com.TransfertNational.demo.Entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="transferts")
public class Transfert {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=13)
	private String referenceTransfert;
	
	@Column(nullable=false, length=4)
	private int pin;
	
	@Column(nullable=false)
	private String etat = "A servir";
	
	
	@Column(nullable=false)
	private float montant;
	
	@Column
	private String motif;
	
	@Column(nullable=false)
	private Boolean notification = false;
	
	@Column(nullable=false)
	private Boolean GAB_BOA = false;

	@ManyToOne
	@JoinColumn(name="agentDonneurtId")
	private Agent agentDonneur;

	@ManyToOne
	@JoinColumn(name="agentBeneficaireId")
	private Agent agentBeneficaire;

	@ManyToOne
	@JoinColumn(name="clientDonneurId")
	private Client clientDonneur;

	@ManyToOne
	@JoinColumn(name="clientBeneficaireId")
	private Client clientBeneficaire;
	
	@Column(nullable=false)
	private Date dateTransfert;
	
	@Column(nullable=false)
	private int delaiTransfert = 7;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferenceTransfert() {
		return referenceTransfert;
	}

	public void setReferenceTransfert(String referenceTransfert) {
		this.referenceTransfert = referenceTransfert;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Boolean getNotification() {
		return notification;
	}

	public void setNotification(Boolean notification) {
		this.notification = notification;
	}

	public Boolean getGAB_BOA() {
		return GAB_BOA;
	}

	public void setGAB_BOA(Boolean GAB_BOA) {
		this.GAB_BOA = GAB_BOA;
	}

	public Agent getAgentDonneur() {
		return agentDonneur;
	}

	public void setAgentDonneur(Agent agentDonneur) {
		this.agentDonneur = agentDonneur;
	}

	public Agent getAgentBeneficaire() {
		return agentBeneficaire;
	}

	public void setAgentBeneficaire(Agent agentBeneficaire) {
		this.agentBeneficaire = agentBeneficaire;
	}

	public Client getClientDonneur() {
		return clientDonneur;
	}

	public void setClientDonneur(Client clientDonneur) {
		this.clientDonneur = clientDonneur;
	}

	public Client getClientBeneficaire() {
		return clientBeneficaire;
	}

	public void setClientBeneficaire(Client clientBeneficaire) {
		this.clientBeneficaire = clientBeneficaire;
	}

	public Date getDateTransfert() {
		return dateTransfert;
	}

	public void setDateTransfert(Date dateTransfert) {
		this.dateTransfert = dateTransfert;
	}

	public int getDelaiTransfert() {
		return delaiTransfert;
	}

	public void setDelaiTransfert(int delaiTransfert) {
		this.delaiTransfert = delaiTransfert;
	}
}
