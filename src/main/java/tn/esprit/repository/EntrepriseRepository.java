package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;
import tn.esprit.entities.Entreprise;


@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Long>{

	@Query("select e from Employe e join e.departements dps join dps.Entreprise entrep where entrep=:entreprise")
	public List<Employe> retrieveemployeesbyEntreprise(@Param("entreprise") Entreprise entreprise);
	
	@Query("Select "
			+ "DISTINCT AVG(cont.salaire) from Contrat cont "
			+ "join cont.Employe emp "
			+ "join emp.departements deps "
			+ "where deps.id=:depId")
    public Double getSalaireMoyenByDepartementId(@Param("depId")long departementId);
}
