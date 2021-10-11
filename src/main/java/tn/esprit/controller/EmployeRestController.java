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

import tn.esprit.entities.Employe;
import tn.esprit.entities.User;
import tn.esprit.service.EmployeService;

@RestController
public class EmployeRestController {
	@Autowired
	EmployeService employeservice ;
	
	// http://localhost:8080/SpringMVC/servlet/addEmploye
		@PostMapping("/addEmploye")
		@ResponseBody
		public Employe addEmploye(@RequestBody Employe employe) {
		return employeservice.addEmploye(employe);
		}
		
		// http://localhost:8080/SpringMVC/servlet/affecterEmployeADepartement
				@PutMapping("/affecterEmployeADepartement/{employeId}/{depId}")
				@ResponseBody
				public void affecterEmployeADepartement(@PathVariable("employeId") int employeId ,@PathVariable("depId") int departementId ) 
				{
				 employeservice.affecterEmployeADepartement(employeId, departementId);
				}
				
				// http://localhost:8080/SpringMVC/servlet/retrieve-all-usersJPQL
				@GetMapping("/retrieve-all-usersJPQL")
				@ResponseBody
				public List<String> getUsers() {
				List<String> liste = employeservice.getAllEmployeNamesJPQL();
				return liste;
				}
}
