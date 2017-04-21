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
import org.proxib.model.Adviser;
import org.proxib.service.IAdviserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component(value = "adviserController")
//@SessionScoped
public class AdviserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

//	@Autowired
	IAdviserService adviserService;

	private Adviser adviser;
	private List<Adviser> listAdviser;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {
		this.adviser = new Adviser();
		this.listAdviser = new ArrayList<>();
		try {

			this.listAdviser.addAll(adviserService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public IAdviserService getAdviserService() {
		return adviserService;
	}

	public void setAdviserService(IAdviserService adviserService) {
		this.adviserService = adviserService;
	}

	public Adviser getAdviser() {
		return adviser;
	}

	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}

	public List<Adviser> getListAdviser() {
		if (listAdviser == null) {
			listAdviser = new ArrayList<Adviser>();
		}
		return listAdviser;
	}

	public void setListAdviser(List<Adviser> listAdviser) {
		this.listAdviser = listAdviser;
	}

	public AdviserController(IAdviserService adviserService, Adviser adviser, List<Adviser> listAdviser) {
		super();
		this.adviserService = adviserService;
		this.adviser = adviser;
		this.listAdviser = listAdviser;
	}

	public AdviserController() {
		super();
	}

}
