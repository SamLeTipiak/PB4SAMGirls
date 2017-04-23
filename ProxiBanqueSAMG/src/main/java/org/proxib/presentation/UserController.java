package org.proxib.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.proxib.model.User;

public class UserController {
	
	private String login, password;
	private User user = new User();
	
	private static Map<String, User> users;
	static {
		users = new HashMap<>();
		users.put("conseiller", new User("toto", "tat"));
	}
	
	public String checkPassword() {
		User user = users.get(login);
		if(user != null && user.getPassword().equals(password)) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			
		}
		return "home2";
	}

}
