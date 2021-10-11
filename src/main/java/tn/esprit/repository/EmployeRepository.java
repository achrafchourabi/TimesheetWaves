package tn.esprit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Employe;
@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {
	@Query("SELECT nom FROM Employe")
    public List<String> employeNamesJPQL();
	
	@Query("SELECT e FROM Employe e WHERE e.email=:email and e.password=:password")
	public Employe getEmployeByEmailAndPassword(@Param("email")String login,
	@Param("password")String password);
	
	@Query(" select u from Employe u " +
            " where u.email = ?1 ")
    Optional<Employe> findUserWithName(String email);
}
