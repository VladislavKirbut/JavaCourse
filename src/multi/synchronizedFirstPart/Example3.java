package multi.synchronizedFirstPart;

public class Example3 {

    private int counter;

    public static void main(String[] args) throws InterruptedException{
        Example3 ex = new Example3();
        ex.doWork1();
    }

    public synchronized void iteration() {
        counter++;
    }

    public void doWork1() throws InterruptedException {

        Thread thread3 = new Thread(() -> {
                for(int i = 0; i < 10000; i++) {
                    iteration();
                }
        });

        Thread thread4 = new Thread(() -> {
               for(int i = 0; i < 10000; i++) {
                   iteration();
               }
        });

        thread3.start();
        thread4.start();

        thread3.join();
        thread4.join();

        System.out.println(counter);
    }
}

