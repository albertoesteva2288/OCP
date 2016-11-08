package ch.diso.ex22_Streams;

import java.util.stream.Stream;

public class StreamFromValues {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of(
                "Mein ", "Name ", "ist ", "Daniel ", "Senften");

        // MEIN NAME IST DANIEL SENFTEN
        stream.map(String::toUpperCase).forEach(System.out::print);
    }
}