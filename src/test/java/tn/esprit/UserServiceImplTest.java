package tn.esprit;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.entities.Role;
import tn.esprit.entities.User;
import tn.esprit.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	UserService us;
	private static final Logger log = LogManager.getLogger(UserServiceImplTest.class);

	

	@Test
	public void testAddUSer() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2015-03-23");
		User u = new User(0, "Achraf", "Chourabi", date, Role.ingenieur);
		assertTrue(u.getRole().equals(Role.ingenieur));
		us.addUser(u);
	}
	
	@Test
	public void testRetrieveUser() {
		User user = us.retrieveUser("6");
		assertNotNull(user.getDateNaissance());
		log.info("retrieveUser : " + user);
	}
	
	@Test
	public void testDeleteUser() {
		if(us!null)
		us.deleteUser("10");
		
	}
	@Test
	public void testRetrieveAllUser() {
		List<User> users = us.retrieveAllUsers();
		log.info("retrieve all users" + users);
		
	}
	@Test
	public void testUpdateUSer() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2015-03-23");
		User u = new User(8, "Achraf", "ChourabiMODIFIE", date, Role.ingenieur);
		assertTrue(u.getRole().equals(Role.ingenieur));
		us.updateUser(u);
	}
	
	
}

































