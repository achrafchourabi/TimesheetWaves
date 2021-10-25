package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	public Mission ajouterMission(Mission mission);
	public List<Mission> getAllMissions();
	public Mission getMissiontById(int missionID);
	public void supprimerMission(int id);
}
