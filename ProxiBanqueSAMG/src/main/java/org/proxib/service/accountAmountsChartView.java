package org.proxib.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.PieChartModel;
import org.proxib.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * La classe accountAmountsChartView permet de visualiser sous forme d'un camembert 
 * (ou diagramme circulaire) qui trie les comptes en fonction de leur solde en 4 parties.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Component
public class accountAmountsChartView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PieChartModel pieModel;

	@Autowired
	private IAccountService accountService;

	
	
	// Constructeurs 
	
	public accountAmountsChartView(PieChartModel pieModel, IAccountService accountService) {
		super();
		this.pieModel = pieModel;
		this.accountService = accountService;
	}
	

	public accountAmountsChartView() {
		super();
	}
	
	
	// Méthodes 


	@PostConstruct
	public void init() {
		createPieModel();
	}
	
	/**
	 * createPieModel() est une méthode qui défini les valeurs rentrées 
	 * pour obtenir le camembert ainsi que les options d'affichage.
	 * 
	 */
	private void createPieModel() {
		pieModel = new PieChartModel();

		List<Account> listAccount = new ArrayList<>();

		try {
			listAccount = accountService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int inf0 = 0, inf1000 = 0, inf5000 = 0, inf10000 = 0, inf50000 = 0, sup50000 = 0;
		double amount = 0;

		for (Account account : listAccount) {
			amount = account.getBalance();

			if (amount < 0) {
				inf0++;
			} else if (amount < 5000) {
				inf5000++;
			} else if (amount < 50000) {
				inf50000++;
			} else {
				sup50000++;
			}

		}

		pieModel.set(" Inférieur à 0 €", inf0);
		pieModel.set(" Entre 1 000€ et 5 000€", inf5000);
		pieModel.set( "Entre 10 000€ et 50 000€", inf50000);
		pieModel.set(" Supérieur à 50 000€", sup50000);
		
		pieModel.setSeriesColors(" da8768, dcfbcc, 9191ea , eccce3");

		pieModel.setTitle("Répartition des comptes en fonction du solde");
		pieModel.setLegendPosition("e");
		pieModel.setFill(true);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(200);
        pieModel.setMouseoverHighlight(true);

	}
	

	
	// Getters Setters 
	
	public PieChartModel getPieModel() {
		return pieModel;
	}



}
