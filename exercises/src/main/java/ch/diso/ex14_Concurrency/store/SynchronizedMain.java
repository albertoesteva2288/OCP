package ch.diso.ex14_Concurrency.store;

public class SynchronizedMain {

    public static void main(String[] args) {
        Store store = Store.getInstance();
        store.addShirt(new Shirt("1", "Polo", "Rainbow", "Large"));

        new CustomerThread().start();
        new CustomerThread().start();
    }
}