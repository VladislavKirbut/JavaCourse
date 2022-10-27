package multi.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Example1 {

    public static void main(String[] args) {

        final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // consumer
        new Thread(() -> {
            while(true) {
                try {
                    queue.take();
                    System.out.println("Consumer get");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //producer
         new Thread(() -> {
            while(true) {
                for(int i = 0; i < 100; i++) {
                    try {
                        queue.put(i);
                        System.out.println("Producer add: " + i);
                        System.out.println(queue);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

