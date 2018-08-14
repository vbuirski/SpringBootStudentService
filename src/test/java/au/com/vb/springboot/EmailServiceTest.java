package au.com.vb.springboot;

import au.com.vb.springboot.model.Email;
import au.com.vb.springboot.service.EmailService;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmailServiceTest {

  private EmailService emailService;


  @Test
  public void shouldSendEmail() {
    Email email = Email.builder().firstName("Vonita")
            .lastName("buirski")
            .emailAddress("vb@gmail.com")
            .build();

    boolean successful = emailService.sendMail(email);
    assertTrue(successful);

  }
}
