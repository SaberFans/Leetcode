package effectiveJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Item67 {
	
	static interface Observer<E>{
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
					observer.added(this, elem);
				}
			}
		}
		
		/**
		 * The method will trigger a concurrent modifcaiton exception, by
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
									observableset.removeObserver(observer);  // the observableset is locked by main notify thread.
									System.out.println("app");
								}
							}).get();
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
			concurrentModificationException();
		}
		
	}
}
