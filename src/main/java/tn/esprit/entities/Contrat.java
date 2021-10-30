package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrat implements Serializable {
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Contrat [reference=" + reference + ", datedebut=" + datedebut + ", typecontrat=" + typecontrat
				+ ", salaire=" + salaire + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reference ;
	@Temporal(TemporalType.DATE)
	private Date datedebut ;
	private String typecontrat ;
	@OneToOne
	private Employe Employe ;
	
	public Contrat(long reference,Date datedebut, String typecontrat, Employe employe,
			double salaire) {
		super();
		this.reference = reference;
		this.typecontrat = typecontrat;
		this.datedebut = datedebut;
		this.Employe = employe;
		this.salaire = salaire;
	}
	public Contrat(String typecontrat,
			double salaire) {
		super();
		this.typecontrat = typecontrat;
		this.salaire = salaire;
	}
	public Contrat(double salaire) {
		super();
		this.salaire = salaire;
	}
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	private double salaire ;
	
	public long getReference() {
		return reference;
	}
	public void setReference(long reference) {
		this.reference = reference;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public String getTypecontrat() {
		return typecontrat;
	}
	public void setTypecontrat(String typecontrat) {
		this.typecontrat = typecontrat;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
}
