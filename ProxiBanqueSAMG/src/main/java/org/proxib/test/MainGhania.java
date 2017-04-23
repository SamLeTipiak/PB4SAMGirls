package org.proxib.test;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Adviser;
import org.proxib.model.Client;
import org.proxib.model.CurrentAccount;
import org.proxib.service.IAdviserService;
import org.proxib.service.IClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainGhania {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IAdviserService adviserService = context.getBean("serviceAdviser", IAdviserService.class);
		IClientService clientService = context.getBean("serviceClient", IClientService.class);

		Adviser ad1 = new Adviser("bernard", "lermite");
		Adviser ad2 = new Adviser("bernardo", "lermite");

		Client c1 = new Client("bob", "marley", "paris", "@");
		Client c2 = new Client("bobby", "marley", "paris", "@");

		CurrentAccount currentAccount = new CurrentAccount(575578.89, 0.6);

		c1.addCurrentAccountToClient(currentAccount);
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
