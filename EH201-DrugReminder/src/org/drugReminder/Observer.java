package org.drugReminder;
import java.util.Date;

public interface Observer {

	/** The Observer interface is used in a hand-made implementation of the 
	 * Observer Design Pattern.  An observer can receive updates from a subject 
	 * after registering for these updates. 
	 * @see java.util.Observer for a built-in Observer. 
	*/
		
	/** Update Observers such as ParticipantLogs with information 
	 * about visits. */
	public void update(Date appointment, String medicine, int dose);

}

