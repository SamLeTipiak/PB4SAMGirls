package org.proxib.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;
import org.proxib.model.Client;
import org.proxib.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "clientController2")
@SessionScoped
public class ClientController2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(ClientController2.class);

	@Autowired
	IClientService clientService;


	private List<Client> listClient;
    
    public List<Client> getListClient() {
		return listClient;
	}


	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	private List<Client> droppedClients;
     
    private Client selectedClient;
     
    @PostConstruct
	public void init() {
		refreshList();
	}

	
	public void refreshList() {
		
		this.selectedClient = new Client();
		this.listClient = new ArrayList<>();
		
	
		try {
			this.listClient.addAll(clientService.findAll());
			
			

			System.out.println("******************");
			System.out.println(listClient);
			System.out.println("******************");
			System.out.println("*");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
     
    public void onClientDrop(DragDropEvent ddEvent) {
        Client car = ((Client) ddEvent.getData());
  
        droppedClients.add(car);
        listClient.remove(car);
    }
     
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
 
    public List<Client> getClients() {
        return listClient;
    }
 
    public List<Client> getDroppedClients() {
        return droppedClients;
    }    
 
    public Client getSelectedClient() {
        return selectedClient;
    }
 
    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

}
