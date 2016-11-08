package ch.diso.ex07_String_Processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindText {

    public static void main(String[] args) {
        FindText find = new FindText();
        find.run();
    }

    private void run() {
        String fileName = "gettys.html";

        // Create Pattern
        // Create Matcher

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            int c = 1;
            while ((line = reader.readLine()) != null) {
                // Generate a matcher based on Pattern
                // Search for text
                // Print results
                c++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}