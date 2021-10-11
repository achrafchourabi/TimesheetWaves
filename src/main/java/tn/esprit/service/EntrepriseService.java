package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Employe;
import tn.esprit.entities.Entreprise;


public interface EntrepriseService {

	
	
	List<Entreprise> retrieveAllEntreprise();
	Entreprise addEntreprise(Entreprise u);
	void deleteEntreprise(String id);
	Entreprise updateEntreprise(Entreprise u);
	Entreprise retrieveEntreprise(String id);
	 List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	  List<Employe> getAllEmployeByEntreprise(Entreprise entreprise);
	  public Double getSalaireMoyenByDepartementId(long departementId);
}
