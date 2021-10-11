package tn.esprit.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;

public interface EmployeService {
	List<Employe> retrieveAllEmploye();
	Employe addEmploye(Employe u);
	void deleteEmploye(String id);
	Employe updateEmploye(Employe u);
	Employe retrieveEmploye(String id);
	void affecterEmployeADepartement(int employeId, int depId);
	public List<String> getAllEmployeNamesJPQL();
	public Employe authenticate(String login, String password);
	
}
