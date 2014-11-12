package com.concurrent.practise;

public class ThreadLocalExample {
	final static ThreadLocal<Integer> tlocal = new ThreadLocal<Integer>();

	public static void main(String[] args) {
		Thread t1 = new Thread() {

			@Override
			public void run() {
				tlocal.set(0);
				System.out.println(tlocal.get());
				while (tlocal.get() < 10) {
					int a = tlocal.get() + 1;
					tlocal.set(a);
					System.out.println("In thread 1:" + tlocal.get());
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				tlocal.set(0);
				System.out.println(tlocal.get());
				while (tlocal.get() < 10) {
					int a = tlocal.get() + 1;
					tlocal.set(a);
					System.out.println("In thread 2:" + tlocal.get());
				}
			}
		};
		t1.start();
		t2.start();
	}

}
