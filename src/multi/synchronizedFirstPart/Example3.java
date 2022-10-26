package multi.synchronizedFirstPart;

public class Example3 {

    private int counter;

    public static void main(String[] args) throws InterruptedException{
        Example3 ex = new Example3();
        ex.doWork1();
    }

    public void doWork1() throws InterruptedException {
        Thread thread3 = new Thread(new Runnable(){
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
           public void run() {
               for(int i = 0; i < 10000; i++) {
                   counter++;
               }
           }
        });

        thread3.start();
        thread4.start();

        thread3.join();
        thread4.join();
    }
}

