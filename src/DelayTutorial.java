import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DelayTutorial {
	private BlockingQueue<Delayed> queue = new DelayQueue<Delayed>();

	public class DelayedElement implements Delayed {

		private long startTime;
		private int value;

		public DelayedElement(int value, int delay) {
			this.value = value;
			startTime = System.currentTimeMillis()+delay;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long diff = startTime - System.currentTimeMillis();
	        return unit.convert(diff, TimeUnit.MILLISECONDS);
		}

		@Override
		public int compareTo(Delayed o) {
			if (this.startTime < ((DelayedElement) o).startTime)
				return -1;
			else if (this.startTime > ((DelayedElement) o).startTime)
				return 1;
			else
				return 0;
		}
		public int getValue(){
			return  value;
		}

	}

	public class Producer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++)
				try {
					Thread.sleep(1000);
					queue.put(new DelayedElement(i, 5000));
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
					System.out.println("value consumed by the consuer "
							+ Thread.currentThread().getName() + "="
							+ ((DelayedElement)queue.take()).getValue());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		DelayTutorial m1 = new DelayTutorial();
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
