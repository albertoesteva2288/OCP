package ch.diso.ex10_IO_Fundamentals;

import java.io.*;
import java.text.NumberFormat;
import java.util.List;

public class DeserializeTest {

    public static void main(String[] args) {
        ShoppingCart cart = null;
        String custID = null;
        System.out.println("Enter the ID of the cart file to deserialize or q exit.");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            custID = in.readLine();
            if (custID.equals("q")) {
                System.exit(0);
            }
        } catch (IOException e) { // Catch any IO exceptions.
            System.out.println("Exception: " + e);
            System.exit(-1);
        }

        String directory = "/tmp/";
        String cartFile = directory + "cart" + custID + ".ser";

        try (FileInputStream fis = new FileInputStream(cartFile);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            cart = (ShoppingCart) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Exception deserializing " + cartFile + ": " + e);
            System.exit(-1);
        }
        System.out.println("Successfully deserialized shopping cart with ID: " + cart.getCartID());
        System.out.println("Shopping cart contains: ");
        List<Item> cartContents = cart.getItems();
        for (Item item : cartContents) {
            System.out.println(item);
        }
        System.out.println("Shopping cart total: "
                + NumberFormat.getCurrencyInstance().format(cart.getCartTotal()));
    }
}