package org.proxib.test;


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
			serviceClient.persist(new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com") );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
