package ch.diso.q04_Functional_Programming;

import java.util.stream.Stream;

public class Q105 {

    public static void main(String[] args) {
        Stream stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));
    }
}
