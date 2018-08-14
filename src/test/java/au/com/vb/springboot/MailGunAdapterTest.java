package au.com.vb.springboot;

import au.com.vb.springboot.model.Email;
import au.com.vb.springboot.service.impl.MailGunAdapter;
import org.junit.Test;

public class MailGunAdapterTest {
  private MailGunAdapter mailGunAdapter = new MailGunAdapter();

  @Test
  public void shouldSendEmail() {
    Email email = Email.builder().firstName("Vonita")
            .lastName("buirski")
            .emailAddress("vb@gmail.com")
            .build();
    mailGunAdapter.sendMail(email);
  }
}
