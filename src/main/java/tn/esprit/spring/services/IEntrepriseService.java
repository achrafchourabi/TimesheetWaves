package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;




public interface IEntrepriseService {
	
	Entreprise addEntreprise(Entreprise e);
	List<Entreprise> retrieveAllEntreprises(); 
	void deleteEntreprise(int id);
	Entreprise updateEntreprise(Entreprise e);
	Entreprise retrieveEntreprise(int id);
	

}
