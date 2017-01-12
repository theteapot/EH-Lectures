package org.drugReminder;

import java.util.ArrayList;
import java.util.Date;

public class Clinic implements Subject {
	
	private Date date;
	private String medicine;
	private int dose;
	
	private ArrayList<Observer> observerList = new ArrayList<Observer>();

	@Override
	public void notifyObservers() {
		for (Observer observer : observerList) {
			observer.update(this.date, this.medicine, this.dose);
		}
	}

	public void setVisit(Date date, String medicine, int dose) {
		this.date = date;
		this.medicine = medicine;
		this.dose = dose;
		notifyObservers();
		return;		
	}

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
		return;		
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
		return;		
	}
	
}
