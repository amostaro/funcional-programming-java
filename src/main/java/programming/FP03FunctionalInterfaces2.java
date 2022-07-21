package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbersList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;

        Function<Integer, Integer> squareFunction = number -> number * number;

        Function<Integer, String> stringOutputFunction = number -> number + " ";

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

        UnaryOperator<Integer> unaryOperator = (x) -> x * 3;
        System.out.println(unaryOperator.apply(1000));

        // NO INPUT -> return something
//        Supplier<Integer> randonIntegerSupplier = () -> 999;
        Supplier<Integer> randonIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(5);
        };
        System.out.println(randonIntegerSupplier.get());

        //BiPredicate
        //BiFunction
        //BiConsumer

        //IntPredicate
        //IntFunction
        //IntConsumer
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator
        //IntBinaryOperator

        //Boolean, Long, Double, Float

        numbersList.stream().filter(isEvenPredicate).map(squareFunction).forEach(sysoutConsumer);

        int sum = numbersList.stream().reduce(0, sumBinaryOperator);
    }
}
