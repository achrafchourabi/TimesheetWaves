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
	public void testAddDepartement() throws ParseException {
		
		Departement d = new Departement("haiaf"); 
		Departement DepartementAdded = dp.addDepartement(d); 
		Assert.assertEquals(d.getName(), DepartementAdded.getName());
	}
	
	@Test
	public void testRetrieveAllDepartement() {
		List<Departement> listDepartements = dp.retrieveAllDepartement(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(11, listDepartements.size());
	}
	
 
	@Test
	public void testModifyDepartement() throws ParseException   {
		Departement d = new Departement(12,"dep info"); 
		Departement DepartementUpdated = dp.updateDepartement(d); 
		Assert.assertEquals(d.getName(), DepartementUpdated.getName());
	}

	@Test
	public void testRetrieveDepartement() {
		Departement departementRetrieved = dp.retrieveDepartement(7); 
		Assert.assertEquals(7, departementRetrieved.getId());
	}
	
	@Test
	public void testDeleteDepartement() {
		dp.deleteDepartement(12);
		Assert.assertNull(dp.retrieveDepartement(12));
	}
	
	// 5 tests unitaires  
	//nbaadel ken fel delete w modif khaw incrimenti b 1
	
}
