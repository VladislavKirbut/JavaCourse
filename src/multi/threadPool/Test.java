package multi.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 5; i++) {
            executorService.execute(new Work(i));
        }
        executorService.shutdown(); // что-то типо метода start()

        executorService.awaitTermination(4, TimeUnit.SECONDS); // что-то типа метода join
        System.out.println("Method main end...");
    }
}

class Work implements Runnable{
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Work " + id + " was completed");
    }
}
