package effectiveJava;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Double checked Locking idoim, which looks clever but doesn't work in
 * multi-threading. Created by epttwxz on May 11, 2017
 */
public class DoubleCheckedLocking {

    /**
     * Initializer wants to keep just one alive instance, and it's checking if
     * has been initialized.
     */
    static class Initializer {
        // use volatile after jdk 1.5, will fix this problem,
        // because it gives you the happens-before relationship 
        // between initialization of SingletonObject by the constructing
        // thread, and the return of its value by the thread that reads it.
        static private volatile SingletonObject dataObj = null;

        static SingletonObject getObject(String data) {
            SingletonObject copy = dataObj;    // this gives 25% better performance...
            if (copy == null) {
                synchronized (Initializer.class) {
                    if (copy == null)
                        copy = dataObj = new SingletonObject(data);
                }
            }
            return copy;    // this may execute before the SingletonObject constructor,
                            // which gives you partially initialized variable.
        }
    }

    /**
     * Data holder.
     */
    static class SingletonObject {
        private String data;

        SingletonObject(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return ("My Data is : " + data);
        }
    }

    public static void main(String[] args) {
        final AtomicInteger counter = new AtomicInteger();
        for (int i = 0; i < 10000; i++) {
            Thread th1 = new Thread() {
                public void run() {
                    int _counter = 0;
                    while (_counter < 1000000) {
                        _counter = counter.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + Initializer.getObject("my previous data"+System.currentTimeMillis()));
                    }
                };

            };
            th1.start();
        }
    }

}
