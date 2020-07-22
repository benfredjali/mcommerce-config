package com.example;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.ClientRepository;
import com.example.dao.CompteRepository;
import com.example.dao.OperationRepository;
import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.CompteEpargne;
import com.example.entities.Retrait;
import com.example.entities.Versement;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	public static void main(String[] args) {
       SpringApplication.run(VotreBanqueApplication.class, args);
	
		
	}

	@Override 
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.save(new Client("Ali","ali@gmail.com"));
		Client c2 = clientRepository.save(new Client("Mohamed","Mohamed@gmail.com"));
		Compte cp1 = compteRepository.save(
				new CompteCourant("c1", new Date(), 90000, c1, 6000));			
		Compte cp2 = compteRepository.save(
				new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(), 5000, cp1));
		operationRepository.save(new Versement(new Date(), 6000, cp2));
		operationRepository.save(new Retrait(new Date(), 4000, cp1));
		operationRepository.save(new Retrait(new Date(), 3000, cp2));
	}

}
