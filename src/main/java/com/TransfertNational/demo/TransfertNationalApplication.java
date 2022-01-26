package com.TransfertNational.demo;

import com.TransfertNational.demo.Entities.Agence;
import com.TransfertNational.demo.Entities.Client;
import com.TransfertNational.demo.Repositorys.AgenceRepository;
import com.TransfertNational.demo.Repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class TransfertNationalApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	AgenceRepository agenceRepository;

	public static void main(String[] args) {
		SpringApplication.run(TransfertNationalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Client clientEntity = new Client();
		clientEntity.setClientId("345TfzR3regr654Greg");
		clientEntity.setTitre("M");
		clientEntity.setFullName("hamza habibou");
		clientEntity.setGSM("0606060606");

		clientRepository.save(clientEntity);

		Client clientEntity2 = new Client();
		clientEntity2.setClientId("alahoakbar12345");
		clientEntity2.setTitre("Mme");
		clientEntity2.setFullName("souad taliban");
		clientEntity2.setGSM("0610203040");

		clientRepository.save(clientEntity2);

		Agence agenceEntity = new Agence();
		agenceEntity.setId(1);
		agenceEntity.setAdresseAgence("Kaouki");
		agenceEntity.setActive(true);
		agenceEntity.setVilleAgence("SAFI");
		agenceEntity.setNomAgence("MASSIRA_AGENCE");
		agenceEntity.setTelephoneAgence("0661968774");

		agenceRepository.save(agenceEntity);

	}
}
