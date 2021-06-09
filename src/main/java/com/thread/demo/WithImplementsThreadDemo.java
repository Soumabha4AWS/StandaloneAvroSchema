package com.thread.demo;


class HiWithImplementsThread implements Runnable {
	
	public void run() {
		for (int i=1;i<=5;i++) {
			System.out.println("************* HiWithImplementsThread *****************");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class HelloWithImplementsThread implements Runnable {
	
	public void run() {
		for (int i=1;i<=5;i++) {
			System.out.println("************** HelloWithImplementsThread ****************");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class WithImplementsThreadDemo {

	public static void main(String[] args) {
		
		Runnable hiWithImplementsThread = new HiWithImplementsThread();
		Runnable helloWithImplementsThread = new HelloWithImplementsThread();
		
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
