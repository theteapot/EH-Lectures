package threadExercises;

public class Exercise3a implements Runnable{

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
