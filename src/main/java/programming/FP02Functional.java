package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

//        List<Integer> doubledNumbers = doubleList(numbers);
//        System.out.println(doubledNumbers);

//        List<Integer> evenNumbers = evenNumbersList(numbers);
//        System.out.println(evenNumbers);

        List<String> coursesLengthString = coursesLengthStringList(courses);
        System.out.println(coursesLengthString);
        List<Integer> coursesLengthNumbers = coursesLengthNumbersList(courses);
        System.out.println(coursesLengthNumbers);

//        int sum = addListStructured(numbers);
//        System.out.println(sum);

//        numbers.stream().distinct().forEach(System.out::println); // não repete
//        numbers.stream().sorted().forEach(System.out::println); // ordenados
//        numbers.stream().distinct().sorted().forEach(System.out::println); // ordenados e não repete

//        courses.stream().sorted().forEach(System.out::println);
//        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println); // ordem natural
//        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); // ordem reversa
//        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println); // ordem pela qtd caracteres

    }

    private static List<String> coursesLengthStringList(List<String> courses) {
        return courses.stream().map(course -> course + " " + course.length()).collect(Collectors.toList()); // string
    }

    private static List<Integer> coursesLengthNumbersList(List<String> courses) {
        return courses.stream().map(course -> course.length()).collect(Collectors.toList()); // numbers
    }

    private static List<Integer> evenNumbersList(List<Integer> numbers) {
        return numbers.stream().filter(number -> number%2 == 0).collect(Collectors.toList());
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        // list 1, 3, 4
        // 1 -> 1
        // 3 -> 9
        // 4 -> 16
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
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
