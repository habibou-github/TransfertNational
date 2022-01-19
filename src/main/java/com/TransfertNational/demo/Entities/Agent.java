package com.TransfertNational.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name="agents")
public class Agent {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String encryptedPassword;
	
	@ManyToOne
	@JoinColumn(name="agenceId")
	private Agence agence;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
