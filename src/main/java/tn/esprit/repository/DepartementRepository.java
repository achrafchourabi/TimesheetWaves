package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long> {
	//select c from contrat c join c. employe from Employe e join e.departements
	




}
