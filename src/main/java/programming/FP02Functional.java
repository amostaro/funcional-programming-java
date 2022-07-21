package programming;

import java.util.Comparator;
import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

//        int sum = addListStructured(numbers);
//        System.out.println(sum);

//        numbers.stream().distinct().forEach(System.out::println); // não repete
//        numbers.stream().sorted().forEach(System.out::println); // ordenados
//        numbers.stream().distinct().sorted().forEach(System.out::println); // ordenados e não repete

//        courses.stream().sorted().forEach(System.out::println);
//        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println); // ordem natural
//        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); // ordem reversa
        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println); // ordem pela qtd caracteres

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
