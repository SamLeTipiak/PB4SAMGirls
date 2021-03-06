package org.proxib.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.proxib.model.Adviser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "userController")
@SessionScoped
public class UserController {

	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private String login, password;
	private Adviser adviser = new Adviser();

	private static Map<String, Adviser> users;
	static {
		users = new HashMap<String, Adviser>();
		users.put("conseiller", new Adviser("conseiller", "toto"));
		users.put("directeur", new Adviser("directeur", "tata"));
	}

	// Méthodes

	public String checkPassword() {
		Adviser u = users.get(login);
		if (u != null && password.equals(u.getPassword())) {
			if ("conseiller".equals(u.getLogin())) {

				return "accueil_conseiller";

			}

			else if ("directeur".equals(u.getLogin())) {
				return "bilan";
			}
		}
		notificationError("Identifiants");
		return "";

	}

	public void notificationSuccess(String operation) {

		LOGGER.info("Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void notificationError(String operation) {

		LOGGER.error("Error");
		LOGGER.info(operation);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public String logout() {

		return "login";
	}

	// Constructeur

	public UserController(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public UserController() {
		super();
	}

	// Getters Setters

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

	public Adviser getAdviser() {
		return adviser;
	}

	public void setUser(Adviser adviser) {
		this.adviser = adviser;
	}

	public static Logger getLOGGER() {
		return LOGGER;
	}

	public static void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	}

}
