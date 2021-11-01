package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Mission;
import tn.esprit.repository.DepartementRepository;
import tn.esprit.repository.MissionRepository;
import tn.esprit.repository.TimesheetRepository;
import tn.esprit.repository.UserRepository;

@Service
public class TimesheetServiceImpl implements TimesheetService{
	@Autowired

	TimesheetRepository timesheetRepository ; 
	@Autowired

	MissionRepository missionRepository ; 
	@Autowired

	DepartementRepository departementRepository ; 
	
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission mission = missionRepository.findById((long)missionId).orElse(null);
		Departement dep = departementRepository.findById((long)depId).orElse(null);
		if (mission!=null)
		mission.setDepartement(dep);
		missionRepository.save(mission);
		
	}
}
