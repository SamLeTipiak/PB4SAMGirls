package org.proxib.service;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateGraphChartView implements Serializable {

	/**
	 * 
	 */
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


	private void createDateModel() {
		dateModel = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		series1.setLabel("Total des sommes transférées par jour en k€");
		series2.setLabel("Nombre de virements par jour");
		
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
//		try {
//			date = dateFormat.parse("2017/04/23");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		date = new Date();
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
			
			dateString = dateFormat.format(date);
			series1.set(dateString, amounts/1000);
			series2.set(dateString, numberOfTransfer);
			date = ajouterJour(date, -1);
		}

		// series1.set("2014-01-01", 51);
		// series1.set("2014-01-06", 22);
		// series1.set("2014-01-12", 65);
		// series1.set("2014-01-18", 74);
		// series1.set("2014-01-24", 24);
		// series1.set("2014-01-30", 51);

		// LineChartSeries series2 = new LineChartSeries();
		// series2.setLabel("Series 2");
		//
		// series2.set("2014-01-01", 32);
		// series2.set("2014-01-06", 73);
		// series2.set("2014-01-12", 24);
		// series2.set("2014-01-18", 12);
		// series2.set("2014-01-24", 74);
		// series2.set("2014-01-30", 62);
		//
		dateModel.addSeries(series1);
		dateModel.addSeries(series2);

		dateModel.setTitle("Nombre et somme des virements par jour  (Zoomer pour voir en détail)");
		dateModel.setZoom(true);
		dateModel.getAxis(AxisType.Y).setLabel("Nombre de virements  & total des sommes en k€");
		dateModel.setLegendPosition("e");
		DateAxis axis = new DateAxis("Dates sur les trente derniers jours");
		axis.setTickAngle(-50);
		//axis.setMax("2017-05-01");
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
