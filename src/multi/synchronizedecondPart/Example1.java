package multi.synchronizedecondPart;

public class Example1 {

    private int counter;

    public static void main(String[] args) throws InterruptedException{
        Example1 ex = new Example1();
        ex.doWork1();
    }

    public void iteration() {
        synchronized (this) {
            counter++;
        }

    }

    public void doWork1() throws InterruptedException {

        Thread thread5 = new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                iteration();
            }
        });

        Thread thread6 = new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                iteration();
            }
        });

        thread5.start();
        thread6.start();

        thread5.join();
        thread6.join();

        System.out.println(counter);
    }
}