package ch.diso.q04_Functional_Programming;

import java.util.stream.Stream;

public class Q113 {

    public static void main(String[] args) {
        Stream.generate(() -> "1")
                .limit(10)                       // N
                .forEach(System.out::println)    // M
        ;
    }
}
