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
import org.proxib.model.Account;
import org.proxib.model.Client;
import org.proxib.service.IAccountService;
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

	@Autowired
	IAccountService accountService;

	private Client client;
	private Client selectedClientDebit;
	private Client selectedClientCredit;

	private double montant;

	private List<Client> listClient;
	private List<Client> listClientUpdate;
	private List<Client> listClientSelected;

	@PostConstruct
	public void init() {
		refreshListTransfer();
	}

	public void refreshListTransfer() {
		this.client = new Client();
		this.selectedClientDebit = new Client();
		this.selectedClientCredit = new Client();
		this.listClient = new ArrayList<>();
		this.listClientSelected = new ArrayList<>();

		this.listClientUpdate = new ArrayList<>();

		this.montant = 0;
		try {
			this.listClient.addAll(clientService.findAll());
			System.err.println(listClient);
			this.listClientSelected.addAll(listClient);
			// this.listClientUpdate.addAll(clientService.findAll());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			this.listClientUpdate = new ArrayList<>();
			this.listClientUpdate.addAll(listClient);
			boolean isdeleted = this.listClientUpdate.remove(this.selectedClientDebit);
			System.out.println("d");
		} catch (Exception e) {
			notificationError(e, "suppression Client");
		}
	}

	public void transfer() {

		try {
			accountService.transfer(selectedClientDebit.getCurrentAccount(), selectedClientCredit.getCurrentAccount(),
					montant);
			notificationSuccess("Virement Effectué");
			refreshListTransfer();
		} catch (Exception e) {
			notificationError(e, "suppression Client");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshListTransfer();
	}

	public void reset() {
		refreshListTransfer();
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

	public Client getselectedClientDebit() {
		return selectedClientDebit;
	}

	public void setselectedClientDebit(Client selectedClientDebit) {
		this.selectedClientDebit = selectedClientDebit;
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

	public Client getSelectedClientCredit() {
		return selectedClientCredit;
	}

	public void setSelectedClientCredit(Client selectedClientCredit) {
		this.selectedClientCredit = selectedClientCredit;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}
