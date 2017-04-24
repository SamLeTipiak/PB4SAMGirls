package org.proxib.presentation;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.proxib.model.Transaction;
import org.proxib.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * La classe DateGraphChartView permet de visualiser sous forme d'un graphique avec des lignes  
 * qui décrit le nombre et la somme total des virements par jour sur les trentes derniers jours.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Component
public class DateGraphChartView implements Serializable {

	private static final long serialVersionUID = 1L;

	private LineChartModel dateModel;

	@Autowired
	private ITransactionService transactionService;

	@PostConstruct
	public void init() {
		createDateModel();
	}

	public LineChartModel getDateModel() {
		return dateModel;
	}

	/**
	 * createDateModel() est une méthode qui défini les valeurs rentrées 
	 * pour obtenir le graphique ainsi que les options d'affichage.
	 * 
	 */
	
	private void createDateModel() {
		
		double totalAmounts = 0;
		
		dateModel = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		series1.setLabel(" Total des sommes transférées par jour en k€");
		series2.setLabel(" Nombre de virements par jour");
		
		List<Transaction> listeTransaction = new ArrayList<>();

		try {
			listeTransaction = transactionService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		double amounts;
		int numberOfTransfer;

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date date=null;

		date = new Date();
		String tomorow = dateFormat.format(ajouterJour(date, 1));
		String dateString="";
		
		
		for (int i=0; i <= 30; i++) {
			numberOfTransfer = 0;
			amounts = 0;
			
			for (Transaction transaction : listeTransaction) {

				if (memeJour(date, transaction.getDate())) {
					numberOfTransfer++;
					amounts += transaction.getAmount();
				}

			}
			totalAmounts+=amounts;
			dateString = dateFormat.format(date);
			series1.set(dateString, amounts/1000);
			series2.set(dateString, numberOfTransfer);
			date = ajouterJour(date, -1);
		}



		
		dateModel.addSeries(series1);
		dateModel.addSeries(series2);

		dateModel.setTitle("Nombre et somme des virements par jour  (Zoomer pour voir en détail)");
		dateModel.setZoom(true);
		dateModel.getAxis(AxisType.Y).setLabel("Nombre de virements & total des sommes en k€");
		dateModel.setLegendPosition("ne");
		DateAxis axis = new DateAxis("");
		axis.setTickAngle(-50);
		axis.setMax(tomorow);
		axis.setTickFormat("%b %#d, %y");
		dateModel.getAxes().put(AxisType.X, axis);
		
	}
	
	private Date ajouterJour(Date date, int nbJour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, nbJour);
		return cal.getTime();
		}
	
	private boolean memeJour(Date date1, Date date2){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dateStr1=dateFormat.format(date1);
		String dateStr2=dateFormat.format(date2);
		dateStr1 = dateStr1.substring(0,10);
		dateStr2 = dateStr2.substring(0,10);
		
		if (dateStr1.equals(dateStr2)){
			return true;
		}else{
			return false;
		}

	}

}
