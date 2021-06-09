package com.thread.demo;



public class WithImplementsThreadAnonymousFunctionDemo {

	public static void main(String[] args) {
		
		Runnable hiWithImplementsThread = () -> {
				for (int i=1;i<=5;i++) {
					System.out.println("************* HiWithImplementsThreadAnonymousFunction *****************");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
	
		
		
		Runnable helloWithImplementsThread = () -> {
				for (int i=1;i<=5;i++) {
					System.out.println("************** HelloWithImplementsThreadAnonymousFunction ****************");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
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
