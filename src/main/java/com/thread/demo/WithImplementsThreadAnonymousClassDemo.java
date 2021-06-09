package com.thread.demo;



public class WithImplementsThreadAnonymousClassDemo {

	public static void main(String[] args) {
		
		Runnable hiWithImplementsThread = new Runnable() {
			public void run() {
				for (int i=1;i<=5;i++) {
					System.out.println("************* HiWithImplementsThreadAnonymousClass *****************");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		
		Runnable helloWithImplementsThread = new Runnable() {
			public void run() {
				for (int i=1;i<=5;i++) {
					System.out.println("************** HelloWithImplementsThreadAnonymousClass ****************");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread1 = new Thread(hiWithImplementsThread);
		Thread thread2 = new Thread(helloWithImplementsThread);
		
		thread1.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread2.start();
		
		
	}

}
