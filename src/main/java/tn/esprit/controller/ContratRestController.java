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

import tn.esprit.entities.Contrat;
import tn.esprit.entities.Employe;
import tn.esprit.service.ContratService;

@RestController
public class ContratRestController {
	@Autowired
	ContratService contratService;

	// http://localhost:8080/SpringMVC/servlet/addContrat
		@PostMapping("/addContrat")
		@ResponseBody
		public Contrat addContrat(@RequestBody Contrat c) {
		return contratService.addContrat(c);
		}
		
    // http://localhost:8080/SpringMVC/servlet/retrieveallcontrats
				@GetMapping("/retrieveallcontrats")
				@ResponseBody
				public List<Contrat> getcontrats() {
				List<Contrat> contrats = contratService.retrieveAllContrat();
				return contrats;
				}

		
}
