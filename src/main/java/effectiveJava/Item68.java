package effectiveJava;

import java.util.concurrent.*;

/**
 * Created by epttwxz on 09/05/2016.
 */
public class Item68 {

    void ScheduleExecutorServiceDemo(){
        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("beep 1 /1sec");
            }
        };

        Runnable twoSec_Task = new Runnable(){
            @Override
            public void run() {
                System.out.println("beep 2 /2sec");
            }
        };

       final ScheduledFuture<?> ret1 = executorService.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
        final ScheduledFuture<?> ret2 = executorService.scheduleAtFixedRate(twoSec_Task, 0, 2, TimeUnit.SECONDS);


       executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("stop the beep 1");
                ret1.cancel(true);

                //this  shutdown will pause all scheduled submission, but all one-show submission will continue to proceed
                //executorService.shutdown();
            }
        }, 3, TimeUnit.SECONDS );

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("stop the beep 2");
                ret2.cancel(true);
                executorService.shutdown();
            }
        }, 10, TimeUnit.SECONDS );

    }

    ExecutorService fixedThreadPoolExample(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run(){
                try {
                    while(true) {
                        Thread.sleep(1000);
                        System.out.println("hi");
                    }
                }
                catch (Exception e){

                }
                finally {

                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run(){
                try {
                    while(true) {
                        Thread.sleep(1000);
                        System.out.println("bye");
                    }
                }
                catch (Exception e){

                }
                finally {

                }
            }
        });

        return executorService;
    }
    public static void main(String[] args) throws InterruptedException{
        new Item68().ScheduleExecutorServiceDemo();

        //ExecutorService service = new Item68().fixedThreadPoolExample();
    }

}
