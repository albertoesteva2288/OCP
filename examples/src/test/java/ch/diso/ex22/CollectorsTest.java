package ch.diso.ex22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CollectorsTest {

    @Test
    public void test1() {
        List<Integer> result = IntStream.range(0, 1000).boxed().collect(Collectors.toCollection(ArrayList<Integer>::new));
        assertEquals(1000, result.size());
    }

    @Test
    public void test2() {
        List<Integer> result = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        assertEquals(1000, result.size());
    }

    @Test
    public void test3() {
        Map<Integer, Integer> map =
                IntStream.range(0, 1000).boxed()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                (x) -> x % 3
                                )
                        );
        assertEquals(1000, map.size());
        assertEquals(Integer.valueOf(0), map.get(111));
    }

}