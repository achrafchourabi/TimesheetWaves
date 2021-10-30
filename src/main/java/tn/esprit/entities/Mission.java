package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Mission {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String name ;
	private String description ;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employe> employees;
	@ManyToOne
	Departement Departement;
	public Set<Employe> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employe> employees) {
		this.employees = employees;
	}
	public Departement getDepartement() {
		return Departement;
	}
	public void setDepartement(Departement departement) {
		Departement = departement;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mission(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Mission [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
