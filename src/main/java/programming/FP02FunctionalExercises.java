package programming;

import java.util.List;

public class FP02FunctionalExercises {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//        int sum = addListStructured(numbers);
//        int sum = squareNumbersAndSumOfSquares(numbers);
//        int sum = cubeNumbersAndSumOfCubes(numbers);
//        int sum = oddNumbersAndSum(numbers);
        int sum = evenNumbersAndSum(numbers);
        System.out.println(sum);

    }

    private static int addListStructured(List<Integer> numbers) {

        return numbers.stream()
//                .reduce(0, FP02Functional :: sum);
//                .reduce(0, (a,b) -> a + b);
                .reduce(0, Integer :: sum);

    }

    private static Integer sum(Integer a, Integer b) {
        // a - aggregate
        // b - next number
        System.out.println(a + " " + b);
        return a + b;
    }

    private static int squareNumbersAndSumOfSquares(List<Integer> numbers) {

        return numbers.stream()
                .map(x -> x * x)
//                .reduce(0, (x,y) -> x * x + y * y);
                .reduce(0, Integer::sum);

    }

    private static int cubeNumbersAndSumOfCubes(List<Integer> numbers) {

        return numbers.stream()
                .map(x -> x * x * x)
//                .reduce(0, (x,y) -> x * x * x + y * y * y);
                .reduce(0, Integer::sum);

    }

    private static int oddNumbersAndSum(List<Integer> numbers) {

        return numbers.stream()
                .filter(number -> number%2 == 1)
//                .reduce(0, FP02Functional :: sum);
//                .reduce(0, (a,b) -> a + b);
                .reduce(0, Integer :: sum);

    }

    private static int evenNumbersAndSum(List<Integer> numbers) {

        return numbers.stream()
                .filter(number -> number%2 == 0)
//                .reduce(0, FP02Functional :: sum);
//                .reduce(0, (a,b) -> a + b);
                .reduce(0, Integer :: sum);

    }
}
