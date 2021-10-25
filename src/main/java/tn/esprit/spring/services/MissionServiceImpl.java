package tn.esprit.spring.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService{
	@Autowired
	MissionRepository MessionRepoistory;
	
	@Override
	public Mission ajouterMission(Mission mission) {
		
		return MessionRepoistory.save(mission);
	}

	@Override
	public List<Mission> getAllMissions() {
		return (List<Mission>) MessionRepoistory.findAll();
	}

	@Override
	public Mission getMissiontById(int missionID) {
		   return MessionRepoistory.findById(missionID).isPresent() ? 
				   MessionRepoistory.findById(missionID).get(): null;
	}

	@Override
	public void supprimerMission(int id) {
		MessionRepoistory.deleteById(id);
		
	}

}
