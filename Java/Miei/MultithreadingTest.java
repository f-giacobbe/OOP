package Miei;

import java.util.concurrent.TimeUnit;

public class MultithreadingTest {
    public static void main(String[] args) {
        printValues();
        printValues();


        Thread t1 = new Thread(MultithreadingTest::printValues);
        Thread t2 = new Thread(MultithreadingTest::printValues);
        t1.start();
        t2.start();
    }

    static void printValues() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
