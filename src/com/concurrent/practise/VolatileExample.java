package com.concurrent.practise;

public class VolatileExample {
	private static volatile Integer tlocal = 0;

	public static void main(String[] args) {
		Thread t1 = new Thread() {

			@Override
			public void run() {
				while (tlocal < 10) {
					System.out.println("In thread 1:" + tlocal++);
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				while (tlocal < 10) {
					System.out.println("In thread 2:" + tlocal++);
				}
			}
		};
		t1.start();
		t2.start();
	}

}
