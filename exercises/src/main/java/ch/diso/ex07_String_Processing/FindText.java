package ch.diso.ex07_String_Processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {

    public static void main(String[] args) {
        FindText find = new FindText();
        find.run();
    }

    private void run() {
        String fileName = "gettys.html";

        Pattern pattern = Pattern.compile("<h4>");
        Matcher matcher;

        // Java 7
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }

        // Java 8
        try {
            Files.lines(Paths.get(fileName))
                    .filter(line -> pattern.matcher(line).find())
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}