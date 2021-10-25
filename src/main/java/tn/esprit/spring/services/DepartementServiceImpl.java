package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {


	@Autowired
	DepartementRepository deptRepoistory;

	public Departement ajouterDepartement(Departement dep) {
		return deptRepoistory.save(dep);
	
	}
	
	public void supprimerDepartement(int id) {
		 deptRepoistory.deleteById(id);
	
	}
	public List<Departement> getAllDepartements() {
		return (List<Departement>) deptRepoistory.findAll();
	}
	
	public Departement getDepartementById(int depID) {
		   return deptRepoistory.findById(depID).isPresent() ? 
				   deptRepoistory.findById(depID).get(): null;

	}



}
