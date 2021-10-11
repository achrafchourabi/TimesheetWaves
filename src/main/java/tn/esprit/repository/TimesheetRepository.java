package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Entreprise;

@Repository
public interface TimesheetRepository extends CrudRepository<Entreprise, Long>{

}
