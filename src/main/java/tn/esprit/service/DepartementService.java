package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Departement;


public interface DepartementService {

	List<Departement> retrieveAllDepartement();
	Departement addDepartement(Departement u);
	void deleteDepartement(String id);
	Departement updateDepartement(Departement u);
	Departement retrieveDepartement(String id);
	void DepartementAEntreprise (int depId,int entrepriseId) ;
	
}
