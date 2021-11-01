package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService entrep; 
	

	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class); 
	
	@Test
	public void A_testAddEntreprise() throws ParseException {
		Entreprise e = new Entreprise("Esprit", "Education"); 
		Entreprise entrepriseAdded = entrep.addEntreprise(e); 
		Assert.assertEquals(e.getName(), entrepriseAdded.getName());
		l.info(" Entreprise ajoutée avec succès");
	}
	
	@Test
	public void B_testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = entrep.retrieveAllEntreprises(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(14, listEntreprises.size());
	}
	
 
	@Test
	public void C_testModifyEntreprise() throws ParseException   {
		Entreprise e = new Entreprise (3,"EspritBusiness", "Ingénieurie"); 
		Entreprise entrepriseUpdated  = entrep.updateEntreprise(e); 
		Assert.assertEquals(e.getName(), entrepriseUpdated.getName());
		l.info(" Entreprise modifiée avec succès");
	}

	@Test
	public void AB_testRetrieveEntreprise() {
		Entreprise entrepriseRetrieved = entrep.retrieveEntreprise(6); 
		Assert.assertEquals(6, entrepriseRetrieved.getId());
		l.info("retrieve Entreprise : "+ entrep);
	}
	
	
	@Test
	public void D_testDeleteEntreprise() {
		entrep.deleteEntreprise(80);
		Assert.assertNull(entrep.retrieveEntreprise(80));
		l.info(" Entreprise supprimée avec succès");
	}
	
	// 5 tests unitaires  

}
