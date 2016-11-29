package ch.diso.ex14_Concurrency.store;

import java.util.Deque;
import java.util.LinkedList;

public class Store {

    private Deque<Shirt> shirts = new LinkedList<>();
    private static Store instance = new Store(); // Singleton

    private Store() {
    }

    static Store getInstance() {
        return instance;
    }

    void addShirt(Shirt shirt) {
        System.out.println("Adding a shirt to the store.");
        shirts.push(shirt);
        System.out.println("Total shirts in stock: " + shirts.size());
    }

    Shirt takeShirt() {
        return shirts.pop();
    }

    int getShirtCount() {
        return shirts.size();
    }

    /*
     * An dieser Stelle würden wir normalerweise die Kreditkarte
     * überprüfen. Da dies eine Weile dauern kann werden wir hier
     * eine kleine Verzögerung einbauen.
     */
    boolean authorizeCreditCard(String accountNumber, double amount) {
        int seconds = (int) (Math.random() * 3 + 1);
        System.out.println("Sleeping for " + seconds + " seconds");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        return true;
    }
}