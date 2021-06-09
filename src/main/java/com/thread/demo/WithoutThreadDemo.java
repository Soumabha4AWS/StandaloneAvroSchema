package com.thread.demo;


class HiWithoutThread {
	
	public void run() {
		for (int i=1;i<=5;i++) {
			System.out.println("************* HiWithoutThread *****************");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class HelloWithoutThread {
	
	public void run() {
		for (int i=1;i<=5;i++) {
			System.out.println("************** HelloWithoutThread ****************");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class WithoutThreadDemo {

	public static void main(String[] args) {
		
		HiWithoutThread hiWithoutThread = new HiWithoutThread();
		HelloWithoutThread helloWithoutThread = new HelloWithoutThread();	
		
		hiWithoutThread.run();
		helloWithoutThread.run();
		
	}

}
