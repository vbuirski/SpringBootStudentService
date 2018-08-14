package au.com.vb.springboot.service;

import au.com.vb.springboot.model.Course;
import au.com.vb.springboot.model.Student;
import java.util.List;

public interface StudentService {
  public List<Student> retrieveAllStudents();

  public Student retrieveStudent(String studentId);

  public List<Course> retrieveCourses(String studentId);

  public Course retrieveCourse(String studentId, String courseId);

  public Course addCourse(String studentId, Course course);
}
