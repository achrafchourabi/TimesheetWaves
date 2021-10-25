package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.services.IEntrepriseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService entrep; 

	@Test
	public void testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = entrep.retrieveAllEntreprises(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(6, listEntreprises.size());
	}
	
	
	@Test
	public void testAddEntreprise() throws ParseException {
		Entreprise e = new Entreprise("Esprit", "Education"); 
		Entreprise entrepriseAdded = entrep.addEntreprise(e); 
		Assert.assertEquals(e.getName(), entrepriseAdded.getName());
	}
 
	@Test
	public void testModifyEntreprise() throws ParseException   {
		Entreprise e = new Entreprise ("EspritBusiness", "Ingénieurie"); 
		Entreprise entrepriseUpdated  = entrep.updateEntreprise(e); 
		Assert.assertEquals(e.getName(), entrepriseUpdated.getName());
	}

	@Test
	public void testRetrieveEntreprise() {
		Entreprise entrepriseRetrieved = entrep.retrieveEntreprise("1"); 
		Assert.assertEquals(1L, entrepriseRetrieved.getId());
	}
	
	@Test
	public void testDeleteEntreprise() {
		entrep.deleteEntreprise("5");
		Assert.assertNull(entrep.retrieveEntreprise("5"));
	}
	
	// 5 tests unitaires  

}
