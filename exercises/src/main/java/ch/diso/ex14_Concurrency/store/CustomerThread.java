package ch.diso.ex14_Concurrency.store;

public class CustomerThread extends Thread {

    @Override
    public void run() {
        PurchasingAgent agent = new PurchasingAgent();
        agent.purchase();
    }

}