package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.service.TimesheetService;

@RestController
public class TimesheetRestController {
@Autowired
	
	TimesheetService timesheetservice;
//http://localhost:8080/SpringMVC/servlet/affecterMissionADepartement/
	@PutMapping(value = "/affecterMissionADepartement/{idmission}/{iddept}") 
	public void affecterMissionADepartement(@PathVariable("idmission") int missionId, @PathVariable("iddept") int depId) {
	timesheetservice.affecterMissionADepartement(missionId, depId);

	}
}
