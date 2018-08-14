package au.com.vb.springboot.model;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Course {
  private String id;
  private String name;
  private String description;
  private List<String> steps;

  public Course(String id, String name, String description, List<String> steps) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.steps = steps;
  }
}
