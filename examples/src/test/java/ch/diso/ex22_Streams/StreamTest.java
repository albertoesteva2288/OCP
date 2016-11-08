package ch.diso.ex22_Streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StreamTest {

    @Test
    public void test1() {
        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
        Stream<String> stream = strings.stream();
        assertEquals(
                "Foo",
                stream.findFirst().get()
        );
    }

    @Test
    public void test2() {
        assertEquals(
                Arrays.asList("Bar", "Baz"),
                Stream.of("Foo", "Bar", "Baz")
                        .filter((s) -> s.startsWith("B"))
                        .collect(Collectors.toList())
        );
    }

    @Test
    public void test3() {
        assertEquals(
                Arrays.asList(3, 3, 3),
                Stream.of("Foo", "Bar", "Baz")
                        .map(String::length)
                        .collect(Collectors.toList())
        );
    }

    @Test
    public void test4() {
        assertEquals(
                Integer.valueOf(9),
                Stream.of("Foo", "BarBar", "BazBazBaz")
                        .map(String::length)
                        .reduce((l, r) -> (l > r ? l : r))
                        .get()
        );
    }

    @Test
    public void test5() {
        assertEquals(
                Arrays.asList("Foo", "Bar", "Baz"),
                Stream.of("Foo Bar Baz")
                        .flatMap((element) -> Arrays.stream(element.split(" ")))
                        .collect(Collectors.toList())
        );
    }

    @Test
    public void test6() {
        assertEquals(
                new ArrayList<String>() {{
                    add("Foo");
                    add("Bar");
                    add("Baz");
                }},
                Stream.of("Foo", "Bar", "Baz", "Baz", "Foo", "Bar")
                        .distinct()
                        .collect(Collectors.toList())
        );
    }

    @Test
    public void test7() {
        assertEquals(
                Arrays.asList("Bar", "Baz", "Foo"),
                Stream.of("Foo", "Bar", "Baz")
                        .sorted(String::compareTo)
                        .collect(Collectors.toList())
        );
    }


}