package ch.diso.q04_Functional_Programming;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q114 {

    public static void main(String[] args) {


        // Original statement
        // Stream.iterate(1, x -> x++).limit(5).map(x -> x).collect(Collectors.joining());

        // Stream.iterate(1, x -> x++).limit(5).map(x -> x).collect(Collectors.joining(""));
        // Stream.iterate(1, x -> x++).limit(5).map(x -> "" + x).collect(Collectors.joining());
        // Stream.iterate(1, x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining());

        Stream.iterate(1, x -> ++x).limit(5).map(x -> x).forEach(System.out::print);


    }
}
