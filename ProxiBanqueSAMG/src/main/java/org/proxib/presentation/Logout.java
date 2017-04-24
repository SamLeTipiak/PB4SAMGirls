package org.proxib.presentation;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component(value = "logout")
@SessionScoped
public class Logout {
	

	  public String logout() {
		  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.removeAttribute("loggedUser");
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        return "/TestLogin.xhtml";
	    }
}
