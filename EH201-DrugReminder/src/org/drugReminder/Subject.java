package org.drugReminder;

/** The Subject interface is used in a hand made implementation of the Observer Design Pattern.  The subject sends updates to observers who are currently registered with the subject. */

public interface Subject {
	
	/** Register an observer to receive updates from the subject. 
	 * @param o the observer that will be registered to receive notification.
	 */
	public void registerObserver(Observer o);
	
	/** Remove an observer so that this observer stops receiving updates from the subject. 
	 * @param o the observer that will be unregistered to stop receiving notification.
	 */
	public void removeObserver(Observer o);
	
	/** Sends an update to all currently registered observers. */
	public void notifyObservers();
}
