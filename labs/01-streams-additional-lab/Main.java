import Models.Classroom;
import Models.Student;
import Models.Teacher;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Classroom classroom = new Classroom();

    classroom.setTeacher(new Teacher("John Doe", 42, "New York"));
    classroom.setStudents(Arrays.asList(
            new Student("John", 20, "New York", 3.5),
            new Student("Jane", 21, "New York", 3.8),
            new Student("Steve", 18, "New York", 3.2),
            new Student("Samantha", 22, "New York", 3.9),
            new Student("Alex", 19, "New York", 3.6),
            new Student("Mary", 20, "New York", 3.7),
            new Student("Tom", 21, "New York", 3.8),
            new Student("Emily", 18, "New York", 3.2),
            new Student("Max", 22, "New York", 3.9),
            new Student("Olivia", 19, "New York", 3.6),
            new Student("James", 20, "New York", 3.7),
            new Student("Sarah", 21, "New York", 3.8),
            new Student("Michael", 18, "New York", 3.2),
            new Student("Jessica", 22, "New York", 3.9),
            new Student("David", 19, "New York", 3.6),
            new Student("Sophia", 20, "New York", 3.7),
            new Student("William", 21, "New York", 3.8),
            new Student("Isabella", 18, "New York", 3.2),
            new Student("Benjamin", 22, "New York", 3.9),
            new Student("Ava", 19, "New York", 3.6)
        )
    );

    System.out.println("+++ Task 1.1: findStudentsBelowAge(int age)");
    classroom
        .getStudents()
        .stream()
        .filter(student -> student.getAge() < 20)
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 1.2: getHighAchievers(double minGrade)");
    classroom
        .getStudents()
        .stream()
        .filter(student -> student.getGrade() >= 3.8)
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 1.3: getHalfTeacherAgeStudents()");
    classroom
        .getStudents()
        .stream()
        .filter(student -> student.getAge() <= classroom.getTeacher().getAge() / 2)
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 2.1: calculateAverageGrade()");
    double averageGrade = classroom
        .getStudents()
        .stream()
        .mapToDouble(Student::getGrade)
        .average()
        .orElse(0);
    System.out.println(averageGrade);

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 2.2: getStudentNames()");
    StringBuilder studentNames = new StringBuilder();
    classroom
        .getStudents()
        .forEach(student -> studentNames.append(student.getName()).append(", "));
    System.out.println(studentNames.substring(0, studentNames.length() - 2));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 2.3: getGradesMap()");
    Map<Character, List<Student>> gradesMap = new HashMap<>();
    List.of('A', 'B', 'C', 'D').forEach(
        grade -> gradesMap.put(grade, new ArrayList<>()
    ));
    classroom
        .getStudents()
        .forEach(student -> {
          if (student.getGrade() >= 9) {
            gradesMap.get('A').add(student);
            return;
          }
          if (student.getGrade() >= 8) {
            gradesMap.get('B').add(student);
            return;
          }
          if (student.getGrade() >= 7) {
            gradesMap.get('C').add(student);
            return;
          }

          gradesMap.get('D').add(student);
        });
    gradesMap.forEach(
        (key, value) -> value.forEach(
            student -> System.out.println(key + ": " + student.toJSON())
        )
    );

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 3.1: sortStudentsByAge()");
    classroom
        .getStudents()
        .stream()
        .sorted(Comparator.comparing(Student::getAge))
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 3.2: sortStudentsByGrade()");
    classroom
        .getStudents()
        .stream()
        .sorted(Comparator.comparing(Student::getGrade).reversed())
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 4.1: findTopPerformers(int count)");
    classroom
        .getStudents()
        .stream()
        .sorted(Comparator.comparing(Student::getGrade).reversed())
        .limit(5)
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 4.2: findLowestPerformers(int count)");
    classroom
        .getStudents()
        .stream()
        .sorted(Comparator.comparing(Student::getGrade))
        .limit(5)
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 4.3: studentsByCity()");
    Map<String, List<Student>> studentsByCity = new HashMap<>();
    classroom
        .getStudents()
        .forEach(student -> {
          if (!studentsByCity.containsKey(student.getCity())) {
            studentsByCity.put(student.getCity(), new ArrayList<>());
          }
          studentsByCity.get(student.getCity()).add(student);
        });
    studentsByCity.forEach(
        (key, value) -> {
          System.out.println(key + ":");
          value.forEach(student -> System.out.println(student.toJSON()));
        }
    );

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 5.1: getInPersonTutoringStudents()");
    System.out.println(classroom.getTeacher().getCity() + ":");
    classroom
        .getStudents()
        .stream()
        .filter(student -> student.getCity().equals(classroom.getTeacher().getCity()))
        .forEach(student -> System.out.println(student.toJSON()));

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 5.2: getUniqueStudentsByCity()");
    Map<String, List<Student>> uniqueStudentsByCity = new HashMap<>();
    classroom
        .getStudents()
        .forEach(student -> {
          if (!uniqueStudentsByCity.containsKey(student.getCity())) {
            uniqueStudentsByCity.put(student.getCity(), new ArrayList<>());
          }
          if (!uniqueStudentsByCity.get(student.getCity()).contains(student)) {
            uniqueStudentsByCity.get(student.getCity()).add(student);
          }
        });
    uniqueStudentsByCity.forEach(
        (key, value) -> {
          System.out.println(key + ":");
          value.forEach(student -> System.out.println(student.toJSON()));
        }
    );

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 5.3: groupStudentsByAgeRange()");
    Map<String, List<Student>> studentsByAgeRange = new HashMap<>();
    classroom
        .getStudents()
        .forEach(student -> {
          Integer age = student.getAge();
          String ageRange = switch (age) {
            case Integer n when n >= 50 -> "50+";
            case Integer n when n >= 40 -> "40–49";
            case Integer n when n >= 30 -> "30–39";
            case Integer n when n >= 20 -> "20–29";
            default -> "<20";
          };

          if (!studentsByAgeRange.containsKey(ageRange)) {
            studentsByAgeRange.put(ageRange, new ArrayList<>());
          }
          studentsByAgeRange.get(ageRange).add(student);
        });

    studentsByAgeRange.forEach(
        (key, value) -> {
          System.out.println(key + ":");
          value.forEach(student -> System.out.println(student.toJSON()));
        }
    );

    System.out.println("--------------------------------------------------");
    System.out.println("+++ Task 5.4: searchStudents(String name, int age, double grade)");
    String name = "John";
    int age = 20;
    double grade = 3.5;
    classroom
        .getStudents()
        .stream()
        .filter(
            student ->
            student.getName().equals(name) && student.getAge() == age && student.getGrade() == grade
        )
        .forEach(student -> System.out.println(student.toJSON()));
  }
}
