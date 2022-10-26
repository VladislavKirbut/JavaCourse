package multi.introduction;

public class Example1 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        Thread thread2 = new Thread(new MyThread2());
        // Если запустить поткок через метод run(), то мы не получим никакой параллельности, сразу выполнится
        // thread1, а затем выполниться следующий код
        try {
            Thread.sleep(4000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName() + " ends");
    }
}


class MyThread1 extends Thread {
    public void run() {
/*        try{
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Hello!!" + Thread.currentThread().getName());
    }
}

class MyThread2 implements Runnable {
    public void run() {
/*        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Hi!!!");
    }
}