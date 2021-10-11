package tn.esprit.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;
import tn.esprit.repository.DepartementRepository;
import tn.esprit.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements EmployeService ,UserDetailsService{
@Autowired
EmployeRepository employeRepository ;
@Autowired
DepartementRepository departementRepository ;
	@Override
	public List<Employe> retrieveAllEmploye() {
		return (List<Employe>) employeRepository.findAll();
	}

	@Override
	public Employe addEmploye(Employe u) {
		employeRepository.save(u) ;
		return u;
	}

	@Override
	public void deleteEmploye(String id) {
		employeRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Employe updateEmploye(Employe u) {
		employeRepository.save(u) ;
		return u;
	}

	@Override
	public Employe retrieveEmploye(String id) {
		return	employeRepository.findById(Long.parseLong(id)).orElse(null);
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		Departement dep = departementRepository.findById((long)depId).get();
		Employe e =  employeRepository.findById((long)employeId).get() ;
		
		dep.getEmployees().add(e);
		departementRepository.save(dep) ;
		
	}
	@Override
	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNamesJPQL();

	}
	@Override
	public Employe authenticate(String login, String password) {
	return employeRepository.getEmployeByEmailAndPassword(login, password);}

	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Objects.requireNonNull(email);
         Employe user =  employeRepository.findUserWithName(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return  user;
    }
}
