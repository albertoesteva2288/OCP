package ch.diso.ex14_Concurrency.store;

import java.util.Deque;
import java.util.LinkedList;

public class Store {

    private Deque<Shirt> shirts = new LinkedList<>();
    private static Store instance = new Store(); // Singleton

    private Store() {
    }

    public static Store getInstance() {
        return instance;
    }

    public void addShirt(Shirt shirt) {
        System.out.println("Adding a shirt to the store.");
        shirts.push(shirt);
        System.out.println("Total shirts in stock: " + shirts.size());
    }

    public Shirt takeShirt() {
        return shirts.pop();
    }

    public int getShirtCount() {
        return shirts.size();
    }

    /*
     * An dieser Stelle würden wir normalerweise die Kreditkarte
     * überprüfen. Da dies eine Weile dauern kann werden wir hier
     * eine kleine Verzögerung einbauen.
     */
    public boolean authorizeCreditCard(String accountNumber, double amount) {

        // TODO Einbau einer Verzögerung

        return true;
    }
}