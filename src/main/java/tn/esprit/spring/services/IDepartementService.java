package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;


public interface IDepartementService {
	
	public Departement ajouterDepartement(Departement dep);
	public List<Departement> getAllDepartements();
	public Departement getDepartementById(int depID);
	
	public void supprimerDepartement(int id);
	

	
}
