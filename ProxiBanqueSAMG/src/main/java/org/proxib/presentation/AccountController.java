package org.proxib.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.proxib.model.Client;
import org.proxib.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value ="clientControll")
@ViewScoped
public class ClientControll implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IClientService clientService;

	private Client client;
	private Client clientSelected;

	private List<Client> listClient;
	private List<Client> listSelected;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public IClientService getiClientService() {
		return clientService;
	}

	public void setiClientService(IClientService iClientService) {
		this.clientService = iClientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClientSelected() {
		return clientSelected;
	}

	public void setClientSelected(Client clientSelected) {
		this.clientSelected = clientSelected;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public List<Client> getListSelected() {
		return listSelected;
	}

	public void setListSelected(List<Client> listSelected) {
		this.listSelected = listSelected;
	}

	public void refreshList() {
		this.client = new Client();
		this.clientSelected = new Client();
		this.listClient = new ArrayList<Client>();
		this.listSelected = new ArrayList<Client>();
		try {
			this.listClient.addAll(clientService.findAll());
			this.listSelected.addAll(listClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
