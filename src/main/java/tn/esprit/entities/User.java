package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class User implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id ;
private String firstName ; 
private String lastName ;
@Temporal(TemporalType.DATE)
private Date dateNaissance ;
@Enumerated(EnumType.STRING)
Role role ;

public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFistName(String fistName) {
	this.firstName = fistName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}

@Override
public String toString() {
	return "User [Id=" + Id + ", fistName=" + firstName + ", lastName=" + lastName + ", dateNaissance=" + dateNaissance
			+ ", role=" + role + "]";
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(long id, String fistName, String lastName, Date dateNaissance, Role role) {
	super();
	Id = id;
	this.firstName = fistName;
	this.lastName = lastName;
	this.dateNaissance = dateNaissance;
	this.role = role;
}

}
