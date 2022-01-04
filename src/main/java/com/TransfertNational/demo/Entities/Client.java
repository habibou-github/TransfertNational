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
	
	@Column(nullable=false, length=100)
	private String identityType;
	
	@Column(nullable=false, length=10)
	private String identityNumbre;
	
	@Column(nullable=false, length=100)
	private Boolean identityValidation = true;
	
	@Column(nullable=false)
	private String paysEmission;
	
	@Column(nullable=false)
	private String paysNationalite;
	
	@Column(nullable=false)
	private String paysAdresse;
	
	@Column(nullable=false)
	private String profession;
	
	@Column(nullable=false)
	private String adresseLegale;
	
	@Column(nullable=false)
	private String ville;
	
	@Column(nullable=false)
	private String GSM;
	
	@Column(nullable=false, length=120, unique=true)
	private String email;
	
	@Column(nullable=false)
	private Date dateNaissance;
	
	
	@OneToOne(mappedBy="client", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Compte comptes;
	



	public Client(String clientId, String fullName, String titre, String identityType, String identityNumbre,
			Boolean identityValidation, String paysEmission, String paysNationalite, String paysAdresse,
			String profession, String adresseLegale, String ville, String GSM, String email, Date dateNaissance) {
		
		super();
		
		this.clientId = clientId;
		this.fullName = fullName;
		this.titre = titre;
		this.identityType = identityType;
		this.identityNumbre = identityNumbre;
		this.identityValidation = identityValidation;
		this.paysEmission = paysEmission;
		this.paysNationalite = paysNationalite;
		this.paysAdresse = paysAdresse;
		this.profession = profession;
		this.adresseLegale = adresseLegale;
		this.ville = ville;
		this.GSM = GSM;
		this.email = email;
		this.dateNaissance = dateNaissance;
	}

	
	


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





	public void setGSM(String gSM) {
		GSM = gSM;
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

	
	
	
	
	
	
	
	
	
	
}