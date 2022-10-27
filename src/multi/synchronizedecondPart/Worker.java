package multi.synchronizedecondPart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Test1 {
    private int counter;

    public static void main(String[] args) {
        new Worker().main();
    }
}

class Worker {
    Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(100)); // случайное число от 0 до 99
    }

    public void addToList2() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(100)); // случайное число от 0 до 99
    }

    public void work() {
        for(int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }
    public void main() {
        long before = System.currentTimeMillis();
        work();
        long after = System.currentTimeMillis();

        System.out.println("Program took " + (after - before) + " ms to run");

        // 4600 ms (в примере WorkerNew рспараллелю по 2 €драм ѕ , чтобы
        // выполнить быстрее)
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }
}