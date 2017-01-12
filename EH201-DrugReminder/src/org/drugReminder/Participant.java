package org.drugReminder;

public class Participant {

	String participantName;
	ParticipantLog participantLog;
	
	Participant(Clinic subject) {
		this.participantLog = new ParticipantLog(subject);
	}

	public void setName(String name) {
		this.participantName = name;
		return;
	}

	public ParticipantLog getParticipantLog() {
		return this.participantLog;		
	}

	public void printVisits() {
		for (String visit : participantLog.appointmentList) {
			System.out.println(visit);
		}
		return;
	}

	public String getName() {
		return this.participantName;
	}
	
}
