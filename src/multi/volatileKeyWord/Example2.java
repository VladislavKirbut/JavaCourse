package multi.volatileKeyWord;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        Thread thread1 = new Thread(myThread);
        thread1.start();

        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        myThread.replaceVariable();
    }
}


class MyThread1 implements Runnable {
    private volatile boolean running = true;
    public void run() {

        while(running) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void replaceVariable() {
        this.running = false;
    }
}