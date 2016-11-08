package ch.diso.ex21;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public class ConstructorReference {

    public static void main(String[] args) {

            /*
             * Constructor with zero arguments.
             */
        {
            // Supplier<Apple> apple = () -> new Apple()
            Supplier<Apple> lambda = Apple::new;
            Apple apple = lambda.get();

            // Apple{color='', weight=0}
            System.out.println(apple);
        }

            /*
             * Constructor with one argument.
             */
        {
            // Function<Integer, Apple> lambda = (weight) -> new Apple(weight);
            Function<Integer, Apple> lambda = Apple::new;
            Apple apple = lambda.apply(110);

            // Apple{color='', weight=110}
            System.out.println(apple);
        }

        /*
         * Constructor with two arguments.
         */
        {
            BiFunction<Integer, String, Apple> lambda = Apple::new;
            Apple apple = lambda.apply(10, "red");

            // Apple{color='red', weight=10}
            System.out.println(apple);
        }

        /*
         * Constructor with three arguments.
         */
        {
            TriFunction<Integer, String, Boolean, Apple> lambda = Apple::new;
            Apple apple = lambda.apply(10, "red", true);

            // Apple{color='red', weight=10, bio=true}
            System.out.println(apple);
        }

    }

    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> f) {
        //        List<Apple> result = new ArrayList<>();
        //        for (Integer e : list) {
        //            result.add(f.apply(e));
        //        }
        // return result;
        return list.stream()
                .map(f)
                .collect(toList());
    }

    /**
     * A local class representing an apple.
     */
    private static class Apple {
        private int weight = 0;
        private String color = "";
        private boolean bio = false;

        Apple() {}

        Apple(int weight) {
            this(weight, "");
        }

        Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Apple(int weight, String color, boolean bio) {
            this(weight, color);
            this.bio = bio;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    ", bio=" + bio +
                    '}';
        }
    }

}