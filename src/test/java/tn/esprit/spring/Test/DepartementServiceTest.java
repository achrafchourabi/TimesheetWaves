package tn.esprit.spring.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceTest {
	@Autowired
	IDepartementService dep;
	private static final Logger l = LogManager.getLogger(DepartementServiceTest.class);
	
	@Test
	public void testAddDepartement() throws ParseException {

	Departement D = new Departement("Dep_GL");
	Departement dep_new= dep.ajouterDepartement(D);
	assertTrue(dep_new.getName().equals("Dep_GL"));
	
	l.info("Dep ajouté  : "+ dep_new);

	}
	
	@Test
	public void testDeleteDepartement() throws ParseException {
		Departement D = new Departement("Dep_TEST");
		Departement dep_new= dep.ajouterDepartement(D);
		int id =dep_new.getId();
		dep.supprimerDepartement(id);
		Departement depart =dep.getDepartementById(id);
		assertNull(depart);
		l.info("Dep supprimé  : "+ dep_new);
	}
	
	/*@Test(timeout = 1)
	public void testAddDepartement2() throws ParseException {
		 long startTime = System.currentTimeMillis();
	Departement D = new Departement("Dep_GL");
	Departement dep_new= dep.ajouterDepartement(D);
	assertNotNull(dep_new.getId());

     long duration = System.currentTimeMillis() - startTime;
		l.info("temps passé : "+ duration + " ms");
	}*/
	/*
	@Test
	public void testRetrieveDepartement2() {
	Departement depart = dep.getDepartementById(0);
	assertNotNull(depart.getId());
	}
	
*/
	@Test
	public void testRetrieveDepartement() throws ParseException {
	Departement depart = dep.getDepartementById(1);
	assertNotNull(depart.getId());
	}
}
