package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + " " + noOfStudents + " " + reviewScore;
    }
}
public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> coursesList = List.of
                (
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("Fullstack", "Fullstack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
                );

        // allMatch, noneMatch, anyMatch - return TRUE or FALSE
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        System.out.println(coursesList.stream().allMatch(reviewScoreGreaterThan95Predicate));

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        System.out.println(coursesList.stream().noneMatch(reviewScoreGreaterThan90Predicate));

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
        System.out.println(coursesList.stream().anyMatch(reviewScoreLessThan90Predicate));

        Comparator<Course> comparingByNoOfStudents = Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudents)
                .collect(Collectors.toList()));
        // [Fullstack 14000 91, Spring Boot 18000 95, Spring 20000 98, Docker 20000 92, Kubernetes 20000 91, AWS 21000 92, Azure 21000 99, API 22000 97, Microservices 25000 96]
        Comparator<Course> comparingByNoOfStudentsDecreasing1 = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudentsDecreasing1)
                .collect(Collectors.toList()));
        // [Microservices 25000 96, API 22000 97, AWS 21000 92, Azure 21000 99, Spring 20000 98, Docker 20000 92, Kubernetes 20000 91, Spring Boot 18000 95, Fullstack 14000 91]
        Comparator<Course> comparingByNoOfStudentsDecreasing2 = Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudentsDecreasing2.reversed())
                .collect(Collectors.toList()));
        // [Microservices 25000 96, API 22000 97, AWS 21000 92, Azure 21000 99, Spring 20000 98, Docker 20000 92, Kubernetes 20000 91, Spring Boot 18000 95, Fullstack 14000 91]
        Comparator<Course> comparingByNoOfStudentsAndReviewScore = Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .collect(Collectors.toList()));
        // [Microservices 25000 96, API 22000 97, Azure 21000 99, AWS 21000 92, Spring 20000 98, Docker 20000 92, Kubernetes 20000 91, Spring Boot 18000 95, Fullstack 14000 91]

        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .limit(5) // pega os 5 primeiros
                .collect(Collectors.toList()));

        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .skip(3) // pula os 3 primeiros
                .collect(Collectors.toList()));

        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList()));

        System.out.println(coursesList.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .limit(5)
                .skip(3)
                .collect(Collectors.toList()));

        System.out.println(coursesList);
        // [Spring 20000 98, Spring Boot 18000 95, API 22000 97, Microservices 25000 96, Fullstack 14000 91, AWS 21000 92, Azure 21000 99, Docker 20000 92, Kubernetes 20000 91]
        System.out.println(coursesList.stream()
                .takeWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));
        // [Spring 20000 98, Spring Boot 18000 95, API 22000 97, Microservices 25000 96]
        System.out.println(coursesList.stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));
        // [Fullstack 14000 91, AWS 21000 92, Azure 21000 99, Docker 20000 92, Kubernetes 20000 91]

        Comparator<Course> comparingByNoOfStudentsAndReviewScoreReversed = Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        // [Microservices 25000 96, API 22000 97, Azure 21000 99, AWS 21000 92, Spring 20000 98, Docker 20000 92, Kubernetes 20000 91, Spring Boot 18000 95, Fullstack 14000 91]
        System.out.println(coursesList.stream()
                .max(comparingByNoOfStudentsAndReviewScoreReversed));
        // Optional[Fullstack 14000 91]
        System.out.println(coursesList.stream()
                .min(comparingByNoOfStudentsAndReviewScoreReversed));
        // Optional[Microservices 25000 96]
        System.out.println(coursesList.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndReviewScoreReversed));
        // Optional.empty
        System.out.println(coursesList.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndReviewScoreReversed)
                .orElse( new Course("Kubernetes", "Cloud", 91, 20000))); // caso nao atenda as condicoes .orElse
        // Kubernetes 20000 91
        System.out.println(coursesList.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findFirst());
        // Optional[Spring 20000 98]
        System.out.println(coursesList.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findAny());
        // Optional[Spring 20000 98]
    }
}
