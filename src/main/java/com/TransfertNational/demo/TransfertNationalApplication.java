package com.TransfertNational.demo;

import com.TransfertNational.demo.Entities.Client;
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

	public static void main(String[] args) {
		SpringApplication.run(TransfertNationalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
		Client clientEntity = new Client();
		clientEntity.setClientId("345TfzR3regr654Greg");
		clientEntity.setFullName("hamza habibou");
		clientEntity.setIdentityType("IdentityType");
		clientEntity.setIdentityNumbre("4325342");
		clientEntity.setAdresseLegale("safi kaouki");
		clientEntity.setDateNaissance(new Date(System.currentTimeMillis()));
		clientEntity.setPaysEmission("Maroc");
		clientEntity.setPaysAdresse("safi");
		clientEntity.setPaysNationalite("Maroccain");
		clientEntity.setProfession("Developer");
		clientEntity.setVille("SAFI");
		clientEntity.setGSM("0606060606");
		clientEntity.setEmail("email@ensas.com");
		clientEntity.setIdentityValidation(true);
		clientEntity.setComptes(null);
		
		clientRepository.save(clientEntity);

 */
	}
}
