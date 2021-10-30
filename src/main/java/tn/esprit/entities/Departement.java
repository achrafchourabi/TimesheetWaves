package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Departement {
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Departement [id=" + id + ", Name=" + Name + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id ;
	private String Name ;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employe> employees;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Departement")
	private Set<Mission> missions;
	@ManyToOne
	Entreprise Entreprise;
	public Set<Employe> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employe> employees) {
		this.employees = employees;
	}
	public Set<Mission> getMissions() {
		return missions;
	}
	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}
	public Entreprise getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		Entreprise = entreprise;
	}
	public Departement(long id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
