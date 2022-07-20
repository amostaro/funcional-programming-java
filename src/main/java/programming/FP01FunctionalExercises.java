package programming;

import java.util.List;

public class FP01FunctionalExercises {

    static List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
            "AWS", "PCF", "Azure", "Docker", "Kubernetes");

    public static void main(String[] args) {

        printAllCoursesIndividually(courses);
        printCoursesContainSpring(courses);
        printCoursesWhoseNameHasAtleastFourLetters(courses);
    }

    private static void printAllCoursesIndividually(List<String> courses) {

        System.out.println(" - AllCoursesIndividually - ");

        courses.stream()
                .forEach(System.out :: println);
    }

    private static boolean isContainSpring(String s) {
        return s.contains("Spring");
    }

    private static void printCoursesContainSpring(List<String> courses) {

        System.out.println(" - CoursesContainSpring - ");

        courses.stream()
//                .filter(FP01FunctionalExercises :: isContainSpring)
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

}
