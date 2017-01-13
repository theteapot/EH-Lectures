package threadExercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Patient extends Thread {
	
	private HeartMonitor hm;
	private Random randInt = new Random();
	
	public void addHeartMonitor(HeartMonitor hm) {
		this.hm = hm;
	}
	
	public void run() {
		
		while (!interrupted()) {
			hm.update();
			try {
				Thread.sleep(Math.abs((randInt.nextInt()%1000)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class HeartMonitor {
	
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private long startTime = System.currentTimeMillis();
	private double heartBeats = 0;
	
	public void update() {
		heartBeats++;
		long elapsedTime = System.currentTimeMillis() - startTime + 1000;
		System.out.println("elapsedTime: "+elapsedTime);
		System.out.println( heartBeats / (elapsedTime/1000)*60 + " bpm");
	}

	public ArrayList<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}
}

public class Exercise5 {
	public static void main(String[] args) throws IOException {
		HeartMonitor hm = new HeartMonitor();
		// TODO Create new person
		Patient patient = new Patient();

		// TODO Add a heart monitor to person
		patient.addHeartMonitor(hm);
		
		// TODO Start person thread
		patient.start();
	}
}

