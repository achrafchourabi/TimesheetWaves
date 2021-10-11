package tn.esprit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;
import tn.esprit.entities.Entreprise;
import tn.esprit.entities.User;
import tn.esprit.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{
@Autowired
EntrepriseRepository entrepriseRepository;
	@Override
	public List<Entreprise> retrieveAllEntreprise() {
	return (List<Entreprise>) entrepriseRepository.findAll();
		
	}

	@Override
	public Entreprise addEntreprise(Entreprise u) {
		entrepriseRepository.save(u) ;
		return u;
	}

	@Override
	public void deleteEntreprise(String id) {
		entrepriseRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise u) {
		entrepriseRepository.save(u) ;
		return u;
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		return	entrepriseRepository.findById(Long.parseLong(id)).orElse(null);
	}
	
	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
	//	Departement Dep = departementRepository.findById((long)depId).get();
		Entreprise en =  entrepriseRepository.findById((long)entrepriseId).get() ;
		List<String> departements = new ArrayList<>() ;
		for (Departement d : en.getDepartements() )
		{
		departements.add(d.getName()) ;
		}
		return departements ;
			
	}

	@Override
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
	return entrepriseRepository.retrieveemployeesbyEntreprise(entreprise) ;
	}
	@Override
	public Double getSalaireMoyenByDepartementId(long departementId) {
		
			return entrepriseRepository.getSalaireMoyenByDepartementId((long)departementId);
		
	}

}
