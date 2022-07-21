package programming;

import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = addListStructured(numbers);
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
}
