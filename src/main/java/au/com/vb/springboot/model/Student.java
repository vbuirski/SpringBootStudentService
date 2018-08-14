package au.com.vb.springboot.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {

  private String id;
  private String name;
  private String description;
  private List<Course> courses;

  public Student(String id, String name, String description, List<Course> courses) {
   super();
   this.id = id;
   this.name = name;
   this.description = description;
   this.courses = courses;
  }

}
