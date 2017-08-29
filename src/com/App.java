package com;

// doesn't work like this
public class App {

	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " started");
				
				Thread threadEmbedded = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try{
							System.out.println(Thread.currentThread().getName() + " started");
							Thread.sleep(2000);						
							System.out.println(Thread.currentThread().getName() + " completed");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}, "thread2");
				
				threadEmbedded.start();
				System.out.println(Thread.currentThread().getName() + " completed");				
			}
		}, "thread1");
		
		thread.start();
		thread.join();
	}

}
