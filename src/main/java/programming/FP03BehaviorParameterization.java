package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviorParameterization {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbersList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> evenPredicate = x -> x % 2 == 0; //behavior
        filterAndPrint(numbersList, evenPredicate);

        Predicate<Integer> oddPredicate = x -> x % 2 == 1; // behavior
        filterAndPrint(numbersList, oddPredicate);

        filterAndPrint(numbersList, x -> x%3 == 0); //behavior

    }

    private static void filterAndPrint(List<Integer> numbersList, Predicate<Integer> predicate) {
        numbersList.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
