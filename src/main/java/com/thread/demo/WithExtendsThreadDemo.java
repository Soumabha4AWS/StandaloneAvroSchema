package com.thread.demo;


class HiWithExtendsThread extends Thread {
	
	public void run() {
		for (int i=1;i<=5;i++) {
			System.out.println("************* HiWithExtendsThread *****************");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class HelloWithExtendsThread extends Thread {
	
	public void run() {
		for (int i=1;i<=5;i++) {
			System.out.println("************** HelloWithExtendsThread ****************");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class WithExtendsThreadDemo {

	public static void main(String[] args) {
		
		HiWithExtendsThread hiWithExtendsThread = new HiWithExtendsThread();
		HelloWithExtendsThread helloWithExtendsThread = new HelloWithExtendsThread();
		
		hiWithExtendsThread.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		helloWithExtendsThread.start();
		
		
	}

}
