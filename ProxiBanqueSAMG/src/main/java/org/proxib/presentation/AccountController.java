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
import org.proxib.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value ="accountController")
@ViewScoped
public class AccountController implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IClientService clientService;

	private static List<Account> listAccount;
	
	private UIData dataTable;

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
		System.out.println("******************************************************************" +listAccount);
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
	
	
	public String createAccount(Long idClient){
		try {
			Client c = clientService.findById(idClient);int nbAccount = 0; 
//			nbAccount = c.getComptes().size(); // a verifier syntaxe une fois les comtpes branchés au client
			if (nbAccount == 2) {
				return "Le client a déjà 1 compte courant et un compte épargne. Vous ne pouvez pas en créer plus.";
			}
			else {
				return "createAccount";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
				
	}
	

}