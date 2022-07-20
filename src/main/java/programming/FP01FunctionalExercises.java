package programming;

import java.util.List;

public class FP01FunctionalExercises {

    static List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
            "AWS", "PCF", "Azure", "Docker", "Kubernetes");

    static List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

    public static void main(String[] args) {

        printAllCoursesIndividually(courses);
        printCoursesContainSpring(courses);
        printCoursesWhoseNameHasAtleastFourLetters(courses);
        printCubesOfOddNumbersInListFunctional(numbers);
        printNumberOfCharactersInEachCourseName(courses);
    }

    private static void printAllCoursesIndividually(List<String> courses) {

        System.out.println(" - AllCoursesIndividually - ");

        courses.stream()
                .forEach(System.out :: println);
    }

    private static boolean containSpring(String s) {
        return s.contains("Spring");
    }

    private static void printCoursesContainSpring(List<String> courses) {

        System.out.println(" - CoursesContainSpring - ");

        courses.stream()
//                .filter(FP01FunctionalExercises :: containSpring)
                .filter(course -> course.contains("Spring"))
                .forEach(System.out :: println);
    }

    private static boolean nameHasAtleastFourLetters(String s) {
        return s.length() >= 4;
    }

    private static void printCoursesWhoseNameHasAtleastFourLetters(List<String> courses) {

        System.out.println(" - CoursesWhoseNameHasAtleastFourLetters - ");

        courses.stream()
//                .filter(FP01FunctionalExercises :: nameHasAtleastFourLetters)
                .filter(course -> course.length() >= 4)
                .forEach(System.out :: println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {

        System.out.println(" - CubesOfOddNumbersInListFunctional - ");

        numbers.stream()
                .filter(number -> number%2 == 1)
                .map(number -> number * number * number)
                .forEach(System.out :: println);
    }

    private static void printNumberOfCharactersInEachCourseName(List<String> courses) {

        System.out.println(" - NumberOfCharactersInEachCourseName - ");

        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out :: println);
    }

}
