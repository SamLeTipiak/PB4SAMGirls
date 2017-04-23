package org.proxib.presentation;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component(value = "logout")
@SessionScoped
public class Logout {
	

	  public String logout() {
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        return "/TestLogin.xhtml";
	    }
}
