package org.drugReminder;

import java.util.ArrayList;
import java.util.Date;

public class ParticipantLog implements Observer{
	
	ArrayList<String> appointmentList = new ArrayList<String>();
	Clinic subject;

	ParticipantLog(Clinic subject) {
		this.subject = subject;
		this.register();
	}
	
	@Override
	public void update(Date date, String medicine, int dose) {
		String appointment = String.format("Date: %s Medicine: %s Dose: %d", date, medicine, dose);
		this.appointmentList.add(appointment);
		return;
	}

	public void remove() {
		subject.removeObserver(this);
		return;
	}

	public void register() {
		subject.registerObserver(this);
		return;		
	}

}
