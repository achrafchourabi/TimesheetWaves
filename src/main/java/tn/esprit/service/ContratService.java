package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Contrat;
import tn.esprit.entities.Departement;


public interface ContratService {
//
	List<Contrat> retrieveAllContrat();
	Contrat addContrat(Contrat c);
	void deleteContrat(long ref);
	void updateContrat(long ref,String typecontrat) ;
	Contrat retrieveContrat(long ref);
	Contrat retrieveContratByEmploye(long empId);
	
}
