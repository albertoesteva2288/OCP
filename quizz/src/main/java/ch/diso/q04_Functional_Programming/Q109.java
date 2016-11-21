package ch.diso.q04_Functional_Programming;

import java.util.stream.Stream;

public class Q109 {

    public static void main(String[] args) {
        Stream<String> s = Stream.generate(() -> "meow");
        boolean match = s.allMatch(String::isEmpty);
        System.out.println(match);
    }
}
