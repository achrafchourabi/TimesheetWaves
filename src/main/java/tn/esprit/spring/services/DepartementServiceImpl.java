package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	@Autowired 
	DepartementRepository  departementRepository;
	
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	
	@Override
	public List<Departement> retrieveAllDepartement() {
		List<Departement> departements = null; 
		try {
		l.info("In retrieveAllDepartement() : ");
		departements = (List<Departement>) departementRepository.findAll();  
		for (Departement dep : departements) {
			l.debug("departement +++ : " + dep);
		} 
		l.info("Out of retrieveAllDepartement() : ");
	}catch (Exception e) {
		l.error("Error in retrieveAllDepartement() : " + e);
	}

	return departements;
	}

	@Override
	public Departement addDepartement(Departement d) {
		return departementRepository.save(d);
	}

	@Override
	public void deleteDepartement(int id) {
		departementRepository.deleteById(id);
		
	}

	@Override
	public Departement updateDepartement(Departement d) {
		return departementRepository.save(d);
	}

	@Override
	public Departement retrieveDepartement(int id) {
		l.info("in  retrieveDepartement id = " + id);
		Departement d =  departementRepository.findById(id).orElse(null);
		//int i = 1/0; 
		//Departement d =   departementRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("departement returned : " + d);
		return d; 
	}

}
