package tn.esprit.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import tn.esprit.config.SecurityConfig;
import tn.esprit.entities.Employe;
import tn.esprit.entities.Role;
import tn.esprit.service.EmployeServiceImpl;

@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
public class ControllerEmployeImpl {
	@Autowired
	EmployeServiceImpl employeService;
	@Autowired
	AppAuthProvider c ;
	private String login; 
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	private String password; 
	private Employe employe;
	private Boolean loggedIn;
	public void auth(){
		Authentication authentication = new UsernamePasswordAuthenticationToken(login, password);;
		Authentication authentication2 = c.authenticate(authentication);
		System.out.print(authentication2);
	}
	public String doLogin() {
		String navigateTo = "null";
		Employe employe=employeService.authenticate(login, password);
		if (employe != null && employe.getRole() == Role.administrateur) {
		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
		Authentication authentication = new UsernamePasswordAuthenticationToken(login, password);;
		//c.authenticate(authentication);
		loggedIn = true; }
		else {
		FacesMessage facesMessage =

		new FacesMessage("Login Failed: please check your username/password and try again.");

		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}

		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";}
}
