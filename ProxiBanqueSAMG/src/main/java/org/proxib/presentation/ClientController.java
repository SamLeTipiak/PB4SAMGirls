package org.proxib.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.proxib.model.Client;
import org.proxib.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IClient iClient;
	
	private static List<Client> listClient = new ArrayList<>();
	
	public void loadClient() {
		listClient.clear();
		try {
			listClient = iClient.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
