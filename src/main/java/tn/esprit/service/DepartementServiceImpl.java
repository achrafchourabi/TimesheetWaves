package tn.esprit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Entreprise;
import tn.esprit.repository.DepartementRepository;
import tn.esprit.repository.EntrepriseRepository;
@Service
public class DepartementServiceImpl implements DepartementService{
@Autowired

DepartementRepository departementRepository ;
@Autowired
EntrepriseRepository  entrepriseRepository ;
	@Override
	public List<Departement> retrieveAllDepartement() {
	return (List<Departement>) departementRepository.findAll();
		
	}

	@Override
	public Departement addDepartement(Departement u) {
		departementRepository.save(u) ;
		return u;
	}

	@Override
	public void deleteDepartement(String id) {
		departementRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Departement updateDepartement(Departement u) {
		departementRepository.save(u) ;
		return u;
	}

	@Override
	public Departement retrieveDepartement(String id) {
		return	departementRepository.findById(Long.parseLong(id)).orElse(null);

	}

	@Override
	public void DepartementAEntreprise(int depId, int entrepriseId) {
		
		Departement dep = departementRepository.findById((long)depId).orElse(null);
		Entreprise en =  entrepriseRepository.findById((long)entrepriseId).orElse(null) ;
		if(dep!=null){
		dep.setEntreprise(en);}
		departementRepository.save(dep) ;
	}
	

}
