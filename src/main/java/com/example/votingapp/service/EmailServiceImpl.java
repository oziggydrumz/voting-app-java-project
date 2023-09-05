package com.example.votingapp.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Configuration
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    JavaMailSender javaMailSender;

    @Override
    public void sendOtpConfirmation(String emailAddress, String otp) throws EmailDeleveringException {

        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom("oziggyDrumz@gmail.com");
            helper.setTo(emailAddress);
            helper.setSubject("otp confirmation");
            helper.setText(otp, true);
            javaMailSender.send(message);




        } catch (MessagingException e) {
            throw new EmailDeleveringException(e);
        }
    }
}
