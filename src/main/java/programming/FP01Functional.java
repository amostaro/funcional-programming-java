package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
        printOddNumbersInListFunctional(numbers);
        printSquaresOfEvenNumbersInListFunctional(numbers);
        printSquaresOfOddNumbersInListFunctional(numbers);
    }

//    private static void print(int number) {
//        System.out.println(number);
//    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {

        // [12, 9, 13, 4, 6, 2, 4, 12, 15] - na vertical
        System.out.println("Functional");
        // Method Reference
//        numbers.stream()
//                .forEach(FP01Functional :: print);

        numbers.stream()
                .forEach(System.out :: println);

    }

//    private static boolean isEven(int number) {
//        return number%2 == 0;
//    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

        // [12, 9, 13, 4, 6, 2, 4, 12, 15] - na vertical
        System.out.println("Functional Even Numbers");
        numbers.stream()
//                .filter(FP01Functional :: isEven) // filter - method reference
                .filter(number -> number%2 == 0) // filter - lambda expression
                .forEach(System.out :: println); // method reference

    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {

        // [12, 9, 13, 4, 6, 2, 4, 12, 15] - na vertical
        System.out.println("Functional Odd Numbers");
        numbers.stream()
                .filter(number -> number%2 == 1) // filter - lambda expression
                .forEach(System.out :: println); // method reference

    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {

        // [12, 9, 13, 4, 6, 2, 4, 12, 15] - na vertical
        System.out.println("Functional Squares Of Even Numbers");
        numbers.stream()
//                .filter(FP01Functional :: isEven) // filter - method reference
                .filter(number -> number%2 == 0) // filter - lambda expression
                // mapping x -> x * x
                .map(number -> number * number)
                .forEach(System.out :: println); // method reference

    }

    private static void printSquaresOfOddNumbersInListFunctional(List<Integer> numbers) {

        // [12, 9, 13, 4, 6, 2, 4, 12, 15] - na vertical
        System.out.println("Functional Squares Of Odd Numbers");
        numbers.stream()
//                .filter(FP01Functional :: isEven) // filter - method reference
                .filter(number -> number%2 == 1) // filter - lambda expression
                // mapping x -> x * x
                .map(number -> number * number)
                .forEach(System.out :: println); // method reference

    }
}
