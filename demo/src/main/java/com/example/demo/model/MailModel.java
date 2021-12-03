package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Configuration
public class MailModel {
    @Autowired
    private JavaMailSender javaMailSender;

    /*@Autowired
    public MailModel(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }*/

    public void sendEmail(String email, String subject, String content) throws MailException {

        /*
         * This JavaMailSender Interface is used to send Mail in Spring Boot. This
         * JavaMailSender extends the MailSender Interface which contains send()
         * function. SimpleMailMessage Object is required because send() function uses
         * object of SimpleMailMessage as a Parameter
         */

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject(subject);
        mail.setText(content);

        javaMailSender.send(mail);
    }

}
