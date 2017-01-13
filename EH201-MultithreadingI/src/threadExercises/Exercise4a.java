package threadExercises;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A counter value which can be incremented
 */
class Counter {
	protected int val = 0;
	
	synchronized public void inc() {
		val++;
	}
	
	/**
	 * Gets the value of the counter
	 * @return the counter value
	 */
	public int getValue() {
		return val;
	}
}

/**
 * A worker thread which shares a counter
 */
class CounterThread implements Runnable{
	private Counter counter = null;
	
	public CounterThread(Counter counter) {
		this.counter = counter;
	}

    public void run() {
    	for (int i=0; i<1000; i++) {
    		counter.inc();
    	}
    }
}

class Exercise4a {
	private static Counter counter = new Counter();
	
	public static void main(String[] args) throws InterruptedException {
		for (int i=0; i<1000; i++) {
			Thread counterThread = new Thread( new CounterThread(counter));
			counterThread.start();
		}
		while (true) {
			Thread.sleep(500);
			System.out.println(counter.getValue());
		}
	}
}
