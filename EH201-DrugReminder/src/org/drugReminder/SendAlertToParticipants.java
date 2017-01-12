package org.drugReminder;

import java.util.Calendar;
import java.util.Date;

/** Main class to test Observer Design Pattern homework. 
 * Creates a clinic.  Creates participants.  Demonstrates sending updates 
 * from the clinic to participants.  Also demonstrates removing and 
 * re-registering participants. */
public class SendAlertToParticipants {

	public static void main(String[] args) {
		// Create Clinic
		Clinic clinic = new Clinic();
		Calendar cal = Calendar.getInstance();
		
		// Create Participant and register observers (in ParticipantLog)
		Participant participant1 = new Participant(clinic);
		participant1.setName("Rita");
		
		Participant participant2 = new Participant(clinic);
		participant2.setName("Dave");
		
		// *******  Create Date Objects HERE and then use the Calendar Object ******** //
		
		// Create visit and send update from clinic to registered participants (use dates created above) 
		clinic.setVisit(cal.getTime(), "ARV", 2);
		cal.roll(Calendar.DAY_OF_MONTH, true);
		clinic.setVisit(cal.getTime(), "Antibiotics", 3);
		cal.roll(Calendar.DAY_OF_MONTH, true);
		// Remove participant from observing clinic updates
		participant1.getParticipantLog().remove();
		
		// Create visit and send update from clinic to registered participants 
		clinic.setVisit(cal.getTime(), "More Antibiotics", 2);
		
		// Create another participant (and register implicitly through participant's log)
		Participant participant3 = new Participant(clinic);
		participant3.setName("Bob");
		
		// Register observers
		participant1.getParticipantLog().register();
		cal.roll(Calendar.DAY_OF_MONTH, true);
		// Create visit and send update from clinic to registered participants 
		clinic.setVisit(cal.getTime(), "Malaria", 1);
		
		// Print out a record to demonstrate which participants received which visit notifications
		System.out.println("Participant:"+participant1.getName());
		participant1.printVisits();
		System.out.println("");
		
		System.out.println("Participant:"+participant2.getName());
		participant2.printVisits();
		System.out.println("");
		
		System.out.println("Participant:"+participant3.getName());
		participant3.printVisits();
	}
}
