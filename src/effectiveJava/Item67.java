package effectiveJava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Item67 {
	
	interface Observer<E>{
		void added(ObservableSet<E> observableset, E elem);
	}
	
	static class ObservableSet<E>{
		private Set<E> registries;
		
		private List<Observer<E>> observers = new ArrayList<>();
		
		public ObservableSet(Set<E> set){
			this.registries = set;
		}
		public void addObserver(Observer<E> observer){
			synchronized (observers) {
				this.observers.add(observer);
			}
		}
		public void removeObserver(Observer<E> observer){
			synchronized (observers) {
				this.observers.remove(observer);
			}
		}
		
		void addElement(E elem){
			if(registries.add(elem)){
				notify(elem);
			}
		}
		void notify(E elem){
			synchronized (observers) {
				for(Observer<E> observer: observers){
					observer.added(this, elem);   // will cause problem here, because different object method invocation,
												 // could cause concurrency problem, as the lock is passed over as well.
				}
			}
		}
		
		/**
		 * The method will trigger a concurrent modification exception, by
		 * removing from the list while the iterating it.
		 */
		static void concurrentModificationException(){
			ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());
			set.addObserver(new Observer<Integer>() {
				@Override
				public void added(ObservableSet<Integer> observableset, Integer elem) {
					System.out.println(elem+" added.");
					// following removal will trigger concurrent modification exception.
					if(elem==23){   
						observableset.removeObserver(this);
						System.out.println("app");
					}
				}
			});
			
			for(int i=1;i<=100;i++){
				set.addElement(i);   
			}
		}
		
		/**
		 * Use a background thread to try to acquire the lock, which is kept by the
		 * main thread.
		 */
		static void deadLockExample(){
			
			ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());
			set.addObserver(new Observer<Integer>() {
				@Override
				public void added(final ObservableSet<Integer> observableset, Integer elem) {
					System.out.println(elem+" added.");
					
					if(elem==23){
						final Observer<Integer> observer = this;
						ExecutorService executorService = Executors.newSingleThreadExecutor();
						try{
							executorService.submit(new Runnable() {
								
								@Override
								public void run() {
									observableset.removeObserver(observer);  // the observer is locked by main notify thread.
									System.out.println("app");
								}
							}).get();   // this thread won't exit until the end of world, just remove the get();
						}
						catch(Exception e){
							throw new AssertionError(e.getCause());
						}
						finally{
							executorService.shutdown();
						}
						
					}
				}
			});
			
			for(int i=1;i<=100;i++){
				set.addElement(i);   
			}
		}
		public static void main(String[] args) {
			// concurrentModificationException();
			deadLockExample();
			
		}
		
	}
}
