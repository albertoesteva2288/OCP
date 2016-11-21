package ch.diso.ex14_Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionCageManager2 {

    private static final int COUNT = 10;

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanCage() {
        System.out.println("Cleaning the cage");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTask(CyclicBarrier cb1, CyclicBarrier cb2) {
        try {
            removeAnimals();
            cb1.await();
            cleanCage();
            cb2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle checked exceptions here
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(COUNT);
            LionCageManager2 manager = new LionCageManager2();

            CyclicBarrier cb1 = new CyclicBarrier(COUNT);
            CyclicBarrier cb2 = new CyclicBarrier(COUNT,
                    () -> System.out.println("*** Cage Cleaned!"));
            for (int i = 0; i < COUNT; i++)
                service.submit(() -> manager.performTask(cb1,cb2));
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
