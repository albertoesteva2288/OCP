package ch.diso.ex10_IO_Fundamentals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;

public class SerializeTest {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart(10);

        cart.addItem(new Item(101, "Whammo Frisbee", 10.95));
        cart.addItem(new Item(123, "Wilson Soccer Pro Soccer ball", 29.95));
        cart.addItem(new Item(45, "Penn Tennis Balls - A set of 4 Cans", 17.49));

        System.out.println("Shopping cart contains " + cart.getCartSize() + " items");
        System.out.println("Shopping cart total: "
                + NumberFormat.getCurrencyInstance().format(cart.getCartTotal()));

        String directory = "/tmp/";
        String cartFile = directory + "cart" + cart.getCartID() + ".ser";

        try (FileOutputStream fos = new FileOutputStream(cartFile);
             ObjectOutputStream o = new ObjectOutputStream(fos)) {
            o.writeObject(cart);
        } catch (IOException e) {
            System.out.println("Exception serializing " + cartFile + ": " + e);
            System.exit(-1);
        }

        System.out.println("Successfully serialized shopping cart with ID: " + cart.getCartID());

    }
}