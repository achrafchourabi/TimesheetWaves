package tn.esprit;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.entities.Contrat;
import tn.esprit.service.ContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	@Autowired
	ContratService ct;
	private static final Logger log = LogManager.getLogger(ContratServiceImplTest.class);

	

	@Test
	public void testAddUSer() throws ParseException {
		Contrat c = new Contrat("cvp",52.5);
		Contrat ctr = ct.addContrat(c);
		Assert.assertTrue(c.getTypecontrat().equals("cvp"));
		log.info("contrat ajouté  : "+ c);
} 
	
	@Test
	public void testRetrieveContrat() {
		Contrat c = ct.retrieveContrat(1);
		Assert.assertEquals(1L, c.getReference());
		log.info("retrieveContrat : " + c);
	}
//	
	@Test
	public void testDeleteContrat() {
		ct.deleteContrat(5);
		Assert.assertNull(ct.retrieveContrat(5));		
	}
	@Test
	public void testRetrieveAllUser() {
		List<Contrat> ctrs = ct.retrieveAllContrat();
		log.info("retrieve all contrats" + ctrs);
		
	}
  	@Test
	public void testUpdateUSer() throws ParseException {
  		 ct.updateContrat(1L,"CDI");
  		Assert.assertTrue(ct.retrieveContrat(1L).getTypecontrat().equals("CDI"));
		 log.info("updated");
  	}
	
	
}

































