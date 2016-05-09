package effectiveJava;

import java.util.concurrent.*;

/**
 * Created by epttwxz on 09/05/2016.
 */
public class Item68 {

    void ScheduleExecutorServiceDemo(){
        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("beep /1sec");
            }
        };

       // final ScheduledFuture<?> ret = executorService.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                //ret.cancel(true);
                //executorService.shutdown();
            }
        }, 3, TimeUnit.SECONDS );

        //executorService.shutdown();
    }

    ExecutorService fixedThreadPoolExample(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);

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
        //new Item68().ScheduleExecutorServiceDemo();

        ExecutorService service = new Item68().fixedThreadPoolExample();

        Thread.sleep(10);
        service.shutdown();

    }

}
