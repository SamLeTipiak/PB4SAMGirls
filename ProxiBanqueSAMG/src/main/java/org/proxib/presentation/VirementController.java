package org.proxib.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.proxib.model.Client;
import org.proxib.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "virementController")
@SessionScoped
public class VirementController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	IClientService clientService;

	private Client client;
	private Client selectedClient;

	private List<Client> listClient;
	private List<Client> listClientUpdate;
	private List<Client> nouvelleliste;
	
	public List<Client> getNouvelleliste() {
		return nouvelleliste;
	}

	public void setNouvelleliste(List<Client> nouvelleliste) {
		this.nouvelleliste = nouvelleliste;
	}

	private List<Client> listClientSelected;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {
		this.client = new Client();
		this.selectedClient = new Client();
		this.listClient = new ArrayList<>();
		this.listClientSelected = new ArrayList<>();
		this.listClientUpdate = new ArrayList<>();
		try {
			this.listClient.addAll(clientService.findAll());
			this.listClientSelected.addAll(listClient);
//			this.listClientUpdate.addAll(clientService.findAll());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateList() {
		this.client = new Client();
		this.selectedClient = new Client();
		this.listClient = new ArrayList<>();
		this.listClientSelected = new ArrayList<>();

		try {
			this.listClient.addAll(clientService.findAll());
			this.listClientSelected.addAll(listClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			clientService.persist(this.client);
			refreshList();
			notificationSuccess("Client ajouté");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			clientService.merge(this.selectedClient);
			refreshList();
			notificationSuccess("Client mis à jour");
		} catch (Exception e) {
			notificationError(e, "Mise à jour client");
		}
	}

	public void refresh() {
		try {
			this.listClientUpdate = new ArrayList<>();
			this.listClientUpdate.addAll(listClient);
			System.out.println(selectedClient);
			System.out.println("********************************before"+ listClientUpdate);
			boolean isdeleted = this.listClientUpdate.remove(this.selectedClient);
			System.out.println(isdeleted);
			System.out.println("********************************AFTER"+ listClientUpdate);
			notificationSuccess("Client supprimé");
		} catch (Exception e) {
			notificationError(e, "suppression Client");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	public void reset() {
		refreshList();
		RequestContext.getCurrentInstance().reset("form1:panel");
	}

	public void notificationSuccess(String operation) {

		LOGGER.info("Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void notificationError(Exception e, String operation) {

		LOGGER.error("Error");
		// Logger.getLogger(this.getClass().getName()).log(Level.ERROR,
		// "Operation "+operation+" Error ",e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public List<Client> getListClient() {
		if (listClient == null) {
			listClient = new ArrayList<Client>();
		}
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public List<Client> getListClientSelected() {
		return listClientSelected;
	}

	public void setListClientSelected(List<Client> listClientSelected) {
		this.listClientSelected = listClientSelected;
	}

	public List<Client> getListClientUpdate() {
		return listClientUpdate;
	}

	public void setListClientUpdate(List<Client> listClientUpdate) {
		this.listClientUpdate = listClientUpdate;
	}

}