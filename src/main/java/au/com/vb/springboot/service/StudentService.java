package au.com.vb.springboot.service;

import au.com.vb.springboot.model.Course;
import au.com.vb.springboot.model.Student;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

  private static List<Student> students = new ArrayList<>();

  static {
    //Initialize Data
    Course course1 = Course.builder().id("Course1").name("Spring").description("10Steps").steps(
            Arrays.asList("Learn Maven", "Import Project", "First Example",
                    "Second Example")).build();
    Course course2 = Course.builder().id("Course2").name("Spring MVC").description("10 Examples").steps(
            Arrays.asList("Learn Maven", "Import Project", "First Example",
                    "Second Example")).build();

    Course course3 = Course.builder().id("Course3").name("Spring Boot").description("6K Students").steps(
            Arrays.asList("Learn Maven", "Learn Spring",
                    "Learn Spring MVC", "First Example", "Second Example")).build();
    Course course4 = Course.builder().id("Course4").name("Maven").description(
            "Most popular maven course on internet!").steps(
            Arrays.asList("Pom.xml", "Build Life Cycle", "Parent POM",
                    "Importing into Eclipse")).build();

    Student ranga = new Student("Student1", "Ranga Karanam",
            "Hiker, Programmer and Architect", new ArrayList<>(Arrays
            .asList(course1, course2, course3, course4)));

    Student satish = new Student("Student2", "Satish T",
            "Hiker, Programmer and Architect", new ArrayList<>(Arrays
            .asList(course1, course2, course3, course4)));

    students.add(ranga);
    students.add(satish);
  }

  public List<Student> retrieveAllStudents() {
    return students;
  }

  public Student retrieveStudent(String studentId) {
    for (Student student : students) {
      if (student.getId().equals(studentId)) {
        return student;
      }
    }
    return null;
  }

  public List<Course> retrieveCourses(String studentId) {
    Student student = retrieveStudent(studentId);
    if (student == null) {
      return null;
    }
    return student.getCourses();
  }

  public Course retrieveCourse(String studentId, String courseId) {
    Student student = retrieveStudent(studentId);
    if (student == null) {
      return null;
    }

    for (Course course : student.getCourses()) {
      if (course.getId().equals(courseId)) {
        return course;
      }
    }
    return null;
  }

  private SecureRandom random = new SecureRandom();

  public Course addCourse(String studentId, Course course) {
    Student student = retrieveStudent(studentId);

    if (student == null) {
      return null;
    }

    String randomId = new BigInteger(130, random).toString(32);

    course.setId(randomId);

    student.getCourses().add(course);

    return course;
  }
}
