package au.com.vb.springboot;

import au.com.vb.springboot.model.Email;
import org.junit.Test;

public class EmailTest {

  @Test
  public void shouldCreateEmail() {

    Email email = Email.builder().firstName("Vonita")
            .lastName("buirski")
            .emailAddress("vb@gmail.com")
            .build();

  }


}
