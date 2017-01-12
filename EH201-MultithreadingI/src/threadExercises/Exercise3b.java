package threadExercises;

public class Exercise3b extends Thread {
	
	public void run() {
		while (true) {
			System.out.println(this.getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			if (interrupted()) {
				break;
			}
		}
	}

}
