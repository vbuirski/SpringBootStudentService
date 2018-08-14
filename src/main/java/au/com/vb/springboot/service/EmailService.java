package au.com.vb.springboot.service;

import au.com.vb.springboot.model.Email;
import au.com.vb.springboot.service.impl.MailGunAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailService {

  private final MailGunAdapter mailGunAdapter;

  public boolean sendMail(Email email) {
    return mailGunAdapter.sendMail(email);
  }
}
