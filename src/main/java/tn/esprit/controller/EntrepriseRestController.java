package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;
import tn.esprit.entities.Entreprise;
import tn.esprit.entities.User;
import tn.esprit.service.EntrepriseService;
@RestController
public class EntrepriseRestController {
	@Autowired
	
	EntrepriseService entrepriseService;
	// http://localhost:8080/SpringMVC/servlet/addEntreprise
			@PostMapping("/addEntreprise")
			@ResponseBody
			public Entreprise addEntreprise(@RequestBody Entreprise entreprise) {
			return entrepriseService.addEntreprise(entreprise);
			}
			
		// http://localhost:8080/SpringMVC/servlet/getDepartementsByEntreprise
					@GetMapping("/getDepartementsByEntreprise/{entreprise_id}")
					@ResponseBody
					public List<String> getDepartementsbyEtreprise(@PathVariable("entreprise_id") int entrepriseId) {
					return entrepriseService.getAllDepartementsNamesByEntreprise(entrepriseId);
					}	
						
					
						
						// http://localhost:8080/SpringMVC/servlet/retrieveEmployeByEntreprise
						@GetMapping("/retrieveEmployeByEntreprise/{entreprise_id}")
						@ResponseBody
						public List<Employe> retrieveEmployeByEntreprise(@PathVariable("entreprise_id") Entreprise entreprise) {
						return entrepriseService.getAllEmployeByEntreprise(entreprise);		}	
						
						// http://localhost:8080/SpringMVC/servlet/getSalaireMoyenByDepartementId
						@GetMapping(value = "/getSalaireMoyenByDepartementId/{departement_id}")
						@ResponseBody
						public double getSalaireMoyenByDepartementId(@PathVariable("departement_id") long departementId) {
						return entrepriseService.getSalaireMoyenByDepartementId(departementId);			
						
					
						}	
						
						
						
						
						
						
						
}
