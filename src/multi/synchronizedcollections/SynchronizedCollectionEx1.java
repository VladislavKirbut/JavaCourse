package multi.synchronizedcollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionEx1 {
    public static void main(String[] args) throws InterruptedException{
        ArrayList<Integer> source = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            source.add(i);
        }
//        ArrayList<Integer> target = new ArrayList<>();
        List<Integer> synchList= Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> {synchList.addAll(source);};
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread2.start();

        thread.join();
        thread2.join();
        System.out.println(synchList);
    }
}
