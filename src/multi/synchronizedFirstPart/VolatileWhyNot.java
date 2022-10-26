package multi.synchronizedFirstPart;

public class VolatileWhyNot {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        VolatileWhyNot test = new VolatileWhyNot();
        test.doWork();
    }

    // 1: 100 -> 101 -> 101 -> 102 -> 103 -> 104 -> 105
    // 2: 100 -> 101 -> 101 -> 102
    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
