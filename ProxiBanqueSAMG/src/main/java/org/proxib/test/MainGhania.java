package org.proxib.test;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Adviser;
import org.proxib.model.Client;
import org.proxib.model.CurrentAccount;
import org.proxib.model.SavingAccount;
import org.proxib.service.IAccountService;
import org.proxib.service.IAdviserService;
import org.proxib.service.IClientService;
import org.proxib.service.ServiceClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sun.faces.renderkit.ClientSideStateHelper;

public class MainGhania {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

	IAdviserService adviserService = context .getBean("serviceAdviser", IAdviserService.class);
	Client c1 = new Client("bob", "marley", "paris", "@");
	Client c2 = new Client("bobby", "marley", "paris", "@");
	Adviser ad1 = new Adviser("bernard", "lermite");
	Adviser ad2 = new Adviser("bernardo", "lermite");
	ad1.addClientToAdviser(c1);
	ad1.addClientToAdviser(c1);
	ad1.addClientToAdviser(c2);
	
	try {
		adviserService.persist(ad1);
		adviserService.persist(ad2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
