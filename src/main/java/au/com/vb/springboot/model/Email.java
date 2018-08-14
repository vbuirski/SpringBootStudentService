package au.com.vb.springboot.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Email {

  private String firstName;
  private String lastName;
  private String emailAddress;

}
