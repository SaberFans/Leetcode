package effectiveJava;

import java.util.concurrent.CountDownLatch;

/**
 * Created by epttwxz on 10/05/2016.
 */
public class Item69 {
     class MyTask implements Runnable{
        private CountDownLatch count;
        MyTask(CountDownLatch countDownLatch){
            this.count = countDownLatch;
        }
        @Override
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.countDown();

        }
    }

    void showCountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10 );
        for(int i=0;i<10;i++){
            new Thread(new MyTask(countDownLatch));
        }
        countDownLatch.await();
        System.out.println("all threads are dead");
    }

    public static void main(String[] args) throws InterruptedException {
        new Item69().showCountDownLatch();

    }
}
