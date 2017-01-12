package threadExercises;

public class Sleeper implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("Printy");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
