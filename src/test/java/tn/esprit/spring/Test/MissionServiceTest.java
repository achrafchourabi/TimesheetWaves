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

import junit.framework.Assert;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IMissionService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceTest {
	@Autowired
	IMissionService mission;
	private static final Logger l = LogManager.getLogger(MissionServiceTest.class);
	
	@Test
	public void testAddMission() throws ParseException {

	Mission M = new Mission("Mission 1" , "Mission test");
	Mission MissionNew= mission.ajouterMission(M);
Assert.assertSame(MissionNew.getName(), "Mission 1");

	
	l.info("Mission ajouté  : "+ MissionNew);

	}
	
	@Test
	public void testDeleteMission() throws ParseException {
		Mission M = new Mission("Mission 1" , "Mission supprimé");
		Mission MissionNew= mission.ajouterMission(M);
		int id =MissionNew.getId();
		mission.supprimerMission(id);
		Mission miss =mission.getMissiontById(id);
		assertNull(miss);
		l.info("Mission supprimé  : "+ MissionNew);
	}
	
	/*@Test(timeout = 1)
	public void testAddMission2() throws ParseException {
		 long startTime = System.currentTimeMillis();
			Mission M = new Mission("Mission 2" , "Mission test2");
			Mission MissionNew= mission.ajouterMission(M);
	assertNotNull(MissionNew.getId());

     long duration = System.currentTimeMillis() - startTime;
		l.info("temps passé : "+ duration + " ms");
	}
	*/
/*	@Test
	public void testRetrieveMission2() {
		Mission miss =mission.getMissiontById(0);
	assertNotNull(miss.getId());
	}
	*/
	@Test
	public void testRetrieveMission() throws ParseException {
		Mission miss = mission.getMissiontById(1);
	assertNotNull(miss.getId());
	}
}
