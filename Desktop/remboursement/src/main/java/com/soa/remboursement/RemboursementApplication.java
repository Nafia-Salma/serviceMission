package com.soa.remboursement;

import com.soa.remboursement.repository.DemandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RemboursementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RemboursementApplication.class, args);
	}

	@Autowired
	private DemandeDao demandeDao;
	@Override
	public void run(String... args) throws Exception {


//	//create demande
//		Demande demande1 = new Demande();
//		demande1.setNom("Nafia");
//		demande1.setPrenom("Salma");
//		demande1.setObjetMission("Conference scrum");
////		demande1.setRefHebergement();
////		demande1.setRefRepas();
////		demande1.setRefDeplacement(deplacementList);
//		demandeDao.save(demande1);

	}
}
