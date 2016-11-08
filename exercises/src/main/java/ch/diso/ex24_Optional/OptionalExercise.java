package ch.diso.ex24_Optional;

import java.util.Optional;

class OptionalExercise {

    /**
     * This method should return the sum of two integer arguments
     *
     * @param a First value to be added
     * @param b Second value to be added
     * @return Sum of the addition
     */
     Integer sum(Integer a, Integer b) {

        /**
         * TODO: This code must be modified in order to run the test
         *
         * @see OptionalTest
         */
        return Optional.ofNullable(a).orElse(0) +
                Optional.ofNullable(b).orElse(0);
    }
}