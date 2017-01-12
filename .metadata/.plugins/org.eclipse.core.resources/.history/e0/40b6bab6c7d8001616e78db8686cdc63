package threadExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercises {
	
	public static void main(String args[]) throws InterruptedException, IOException {
		//Exercise 1
		/*Thread sleeper = new Thread(new Sleeper() );
		sleeper.start();*/
		
		//Exercise 2
		/*Exercise2 ex2 = new Exercise2();
		ex2.start();
		System.out.println("Waiting for ex2 to finish");
		ex2.join();*/
		
		//Exercise 3a
	    /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while (true) {
	    	String input = br.readLine();
	    	if (input.compareTo("y") == 0) {
	    		Thread thread = new Thread(new Exercise3a());
	    		thread.start();
	    	} else if (input.compareTo("q") == 0) {
	    		System.exit(0);
	    	}
	    }*/
		//Exercise 3b
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Exercise3b> threadList = new ArrayList<Exercise3b>();
	    while (true) {
	    	String input = br.readLine();
	    	if (input.compareTo("y") == 0) {
	    		Exercise3b thread = new Exercise3b();
	    		threadList.add(thread);
	    		thread.start();
	    	} 
	    	if (input.compareTo("q") == 0) {
	    		for (Exercise3b thread : threadList) {
	    			thread.interrupt();	    			
	    		}
	    		System.exit(69);
	    	}
	    }
	    
	}

}