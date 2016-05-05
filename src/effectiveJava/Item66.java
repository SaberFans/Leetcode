package effectiveJava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Item66 {
	private static int counter = 1;
	private static AtomicInteger atomic_counter = new AtomicInteger(1);
	
	public static void main(String[] args) throws InterruptedException {
		Thread myTh1 = new Thread(){
			public void run() {
				counter++;
				atomic_counter.incrementAndGet();
			}
			
		};
		myTh1.start();
		
		Thread myTh2 = new Thread(){
			public void run() {
				counter++;
				atomic_counter.incrementAndGet();
			}
			
		};
		
		myTh2.start();
		
		Thread myTh3 = new Thread(){
			public void run() {
				counter++;
				atomic_counter.incrementAndGet();
			}
			
		};
		myTh3.start();
		Thread myTh4 = new Thread(){
			public void run() {
				counter++;
				atomic_counter.incrementAndGet();
			}
			
		};
		myTh4.start();
		Thread myTh5 = new Thread(){
			public void run() {
				counter++;
				atomic_counter.incrementAndGet();
			}
			
		};
		myTh5.start();
		Thread myTh6 = new Thread(){
			public void run() {
				counter++;
				atomic_counter.incrementAndGet();
			}
			
		};
		myTh6.start();
		
		
		Thread watcherTh = new Thread(){
			public void run() {
				
				while(atomic_counter.get()==counter){
					System.out.print(".");
				}
			}
			
		};
		
		TimeUnit.SECONDS.sleep(1);
		watcherTh.start(); 
	}
}
