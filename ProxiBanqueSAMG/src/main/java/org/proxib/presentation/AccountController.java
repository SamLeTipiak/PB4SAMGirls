package org.proxib.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.primefaces.component.api.UIData;
import org.proxib.model.Account;
import org.proxib.model.Client;
import org.proxib.service.IAccountService;
import org.proxib.service.IClientService;
import org.proxib.service.impl.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "accountController")
@ViewScoped
public class AccountController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IClientService clientService;

	private static List<Account> listAccount;
	private static List<Client> clientsOverdraft = new ArrayList<>();
	private int taille;

	private UIData dataTable;

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public AccountController() throws Exception {
		this.listAccount = new ArrayList<>();
	}

	public List<Account> getListAccount() {
		loadAccount();
		return listAccount;
	}

	public void loadAccount() {
		listAccount.clear();
		try {
			listAccount = accountService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String createAccount(Long idClient) {
		try {
			Client c = clientService.findById(idClient);
			int nbAccount = 0;
			if (nbAccount == 2) {
				return "Le client a déjà 1 compte courant et un compte épargne. Vous ne pouvez pas en créer plus.";
			} else {
				return "createAccount";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	public List<Client> getClientsOverdraft() {
		loadClientsOverdraft();
		return clientsOverdraft;
	}

	public void loadClientsOverdraft() {
		clientsOverdraft.clear();
		try {
			clientsOverdraft = accountService.doAudit(0.0);
			taille = clientsOverdraft.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	

}
