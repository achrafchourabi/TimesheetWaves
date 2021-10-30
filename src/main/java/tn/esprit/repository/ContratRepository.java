package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.entities.Contrat;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Long> {
	@Query(value = "SELECT * FROM Contrat where Employe = ?1", nativeQuery = true) Contrat findContartByEmployee(Long emplid);	
	@Transactional
	@Modifying
	@Query("UPDATE Contrat c " + "SET c.typecontrat = ?1 WHERE c.reference = ?2")void updateC(String typecontrat , long  ref);
	




}
