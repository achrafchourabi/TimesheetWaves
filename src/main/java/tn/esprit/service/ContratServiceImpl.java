package tn.esprit.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Contrat;
import tn.esprit.repository.ContratRepository;
@Service
public class ContratServiceImpl implements ContratService{
@Autowired

ContratRepository contratRepository ;
	@Override
	public List<Contrat> retrieveAllContrat() {
	return (List<Contrat>) contratRepository.findAll();
		
	}

	@Override
	public Contrat addContrat(Contrat c) {
		Date cdate = new Date();
		c.setDatedebut(cdate);
		contratRepository.save(c) ;
		return c;
	}


	


	@Override
	public void deleteContrat(long ref) {
		contratRepository.deleteById(ref);
		
	}

	@Override
	public Contrat retrieveContrat(long ref) {
		return	contratRepository.findById(ref).orElse(null);

	}

	@Override
	public Contrat retrieveContratByEmploye(long empId) {
		return	contratRepository.findContartByEmployee(empId);
		
	}

	@Override
	public void updateContrat(long ref, String typecontrat) {
		 contratRepository.updateC(typecontrat, ref);
	
	}
	

}
