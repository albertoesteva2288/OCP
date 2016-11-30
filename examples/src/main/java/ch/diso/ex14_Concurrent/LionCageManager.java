package ch.diso.ex14_Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionCageManager {

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

    public void performTask() {
        removeAnimals();
        cleanCage();
        addAnimals();
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(3);
            LionCageManager manager = new LionCageManager();
            for (int i = 0; i < COUNT; i++)
                service.submit(() -> manager.performTask());
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
