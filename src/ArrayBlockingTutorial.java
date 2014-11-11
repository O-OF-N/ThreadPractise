import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayBlockingTutorial {

	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public class Producer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++)
				try {
					Thread.sleep(1000);
					queue.put(i);
					System.out.println("Value enterd by the producer = " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		}

	}

	public class Consumer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++)
				try {
					System.out
							.println("value consumed by the consuer "
									+ Thread.currentThread().getName() + "="
									+ queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ArrayBlockingTutorial m1 = new ArrayBlockingTutorial();
		Producer p1 = m1.new Producer();
		Consumer c1 = m1.new Consumer();
		Consumer c2 = m1.new Consumer();
		Consumer c3 = m1.new Consumer();
		Consumer c4 = m1.new Consumer();
		Consumer c5 = m1.new Consumer();
		executor.submit(p1);
		executor.submit(c1);
		executor.submit(c2);
		executor.submit(c3);
		executor.submit(c4);
		executor.submit(c5);

	}

}
