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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {

	@Autowired
	IDepartementService dp;
	
	@Test
	public void testRetrieveAllDepartement() {
		List<Departement> listDepartements = dp.retrieveAllDepartement(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(9, listDepartements.size());
	}
	
	
/*	@Test
	public void testAddDepartement() throws ParseException {
		
		Departement d = new Departement("informatique"); 
		Departement DepartementAdded = dp.addDepartement(d); 
		Assert.assertEquals(d.getName(), DepartementAdded.getName());
	}
 
	@Test
	public void testModifyDepartement() throws ParseException   {
		Departement d = new Departement("technique"); 
		Departement DepartementUpdated = dp.updateDepartement(d); 
		Assert.assertEquals(d.getName(), DepartementUpdated.getName());
	}*/

	@Test
	public void testRetrieveDepartement() {
		Departement departementRetrieved = dp.retrieveDepartement("2"); 
		Assert.assertEquals(1L, departementRetrieved.getId());
	}
	
	@Test
	public void testDeleteDepartement() {
		dp.deleteDepartement("2");
		Assert.assertNull(dp.retrieveDepartement("2"));
	}
	
	// 5 tests unitaires  
	
}
