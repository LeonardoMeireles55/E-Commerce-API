package com.leonardo.ecommerce.service.user;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.leonardo.ecommerce.record.admin.EmailDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(EmailDTO email) {
        var message = new SimpleMailMessage();
        message.setFrom("noreply@newEmail.com");
        message.setTo(email.to());
        message.setSubject(email.subject());
        message.setText(email.body());
        javaMailSender.send(message);
    }

}
