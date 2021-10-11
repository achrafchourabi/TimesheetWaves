package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Departement;
import tn.esprit.service.DepartementService;
@RestController
public class DepartementRestController {
	@Autowired
	DepartementService departementService;
	// http://localhost:8080/SpringMVC/servlet/addDepartement
	@PostMapping("/addDepartement")
	@ResponseBody
	public Departement addDepartement(@RequestBody Departement departement) {
	return departementService.addDepartement(departement);
	}
	
	// http://localhost:8080/SpringMVC/servlet/affecterDepartementAEntreprise
		@PutMapping("/affecterDepartementAEntreprise/{departementId}/{entrepriseId}")
		@ResponseBody
		public void affecterDepartementAEntreprise(@PathVariable("departementId") int departementId ,@PathVariable("entrepriseId") int entrepriseId ) 
		{
		 departementService.DepartementAEntreprise(departementId, entrepriseId);
		}
		
		
}
