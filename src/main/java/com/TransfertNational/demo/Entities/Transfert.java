package com.TransfertNational.demo.Entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="transferts")
public class Transfert {
	
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false)
	private String transfertId;

	@Column(nullable=false, length=13)
	private String referenceTransfert;
	
	@Column(length=4)
	private String pin;
	
	@Column(nullable=false)
	private String etat = "A servir";
	
	
	@Column(nullable=false)
	private float montant;
	
	@Column
	private String motif;
	
	@Column
	private Boolean notification = false;
	
	@Column
	private Boolean GAB_BOA = false;

	@ManyToOne
	@JoinColumn(name="clientDonneurId")
	private Client clientDonneur;

	@ManyToOne
	@JoinColumn(name="clientBeneficaireId")
	private Client clientBeneficaire;
	
	@Column(nullable=false)
	private Date dateTransfert;

	@Column
	private Date dateReception;
	
	@Column(nullable=false)
	private int delaiTransfert = 7;

	@Column(nullable=false)
	private String typeTransfert;

	public String getTypeTransfert() {
		return typeTransfert;
	}

	public void setTypeTransfert(String typeTransfert) {
		this.typeTransfert = typeTransfert;
	}

	public String getTransfertId() {
		return transfertId;
	}

	public void setTransfertId(String transfertId) {
		this.transfertId = transfertId;
	}

	public Date getDateReception() {
		return dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}

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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
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
