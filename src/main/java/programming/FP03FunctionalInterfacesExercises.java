package programming;

import java.util.List;
import java.util.function.*;

public class FP03FunctionalInterfacesExercises {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbersList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        BinaryOperator<Integer> sumOperatorSupplier = Integer::sum;
        BinaryOperator<Integer> sumOperatorSupplier2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        int sum = numbersList.stream()
//                .reduce(0, sumOperatorSupplier);   // Function
                .reduce(0, sumOperatorSupplier2); // Function

        System.out.println(sum);



    }
}
