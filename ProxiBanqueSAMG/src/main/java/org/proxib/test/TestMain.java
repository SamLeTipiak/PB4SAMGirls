package org.proxib.test;


import java.util.ArrayList;
import java.util.List;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Client;
import org.proxib.service.IClientService;
import org.proxib.service.ServiceClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		IClientService serviceClient = context.getBean("serviceClient", ServiceClient.class);
		try {
			Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
			Client c2 = new Client("Paula", "Lis", "18 rue des oliviers 75001 Paris", "paula.lis@gmail.com");
			List<Client> clients = new ArrayList<>();
			clients.add(c1);
			clients.add(c2);
			serviceClient.persist(c1);
			serviceClient.persist(c2);
			System.out.println(clients);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
