package org.proxib.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.SessionScoped;

import org.proxib.model.User;
import org.springframework.stereotype.Component;

@Component(value = "userController")
@SessionScoped
public class UserController {

	private String login, password;
	private User user = new User();

	private static Map<String, User> users;
	static {
		users = new HashMap<String,User>();
		users.put("conseiller", new User("toto", "tata"));
	}

	public String checkPassword() {
		User user = users.get(login);
		if (user != null && user.getPassword().equals(password)) {
			// HttpSession session = (HttpSession)
			// FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			return "accueil_conseiller2.xhtml";
		}

		return "";

	}

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

}
