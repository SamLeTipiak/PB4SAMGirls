package org.proxib.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.primefaces.component.api.UIData;
import org.proxib.model.Client;
import org.proxib.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component(value="clientController")
@ViewScoped
public class ClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IClientService iClientService;

	private static List<Client> listClient = new ArrayList<>();
	
	private UIData dataTable;

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ClientController() throws Exception {
		listClient = new ArrayList<>();

	}
	
	public List<Client> getListClient() {
		loadClient();
		System.out.println("******************************************************************" +listClient);
		return listClient;
	}
	
	public void loadClient() {
		listClient.clear();
		try {
			listClient = iClientService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
