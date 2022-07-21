package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterizationExercises {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbersList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Function<Integer, Integer> mappingFunctionSquaredNumbers = x -> x * x;
        List<Integer> newSquaredNumbersList = mapAndCreateList(numbersList, mappingFunctionSquaredNumbers);
        System.out.println(newSquaredNumbersList);

        Function<Integer, Integer> mappingFunctionCubeNumbers = x -> x * x * x;
        List<Integer> newCubeNumbersList = mapAndCreateList(numbersList, mappingFunctionCubeNumbers);
        System.out.println(newCubeNumbersList);

    }

    private static List<Integer> mapAndCreateList(List<Integer> numbersList, Function<Integer, Integer> mappingFunctionNumbers) {
        return numbersList.stream()
                .map(mappingFunctionNumbers)
                .collect(Collectors.toList());
    }

}
