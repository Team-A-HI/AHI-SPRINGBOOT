package com.jsg.ahispringboot.member.utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@RequiredArgsConstructor
public class MailSend {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

/*
    public void sendEmail(String to, String subject, String text) {
        String mail = "변경된 비밀번호입니다."+text+"비밀번호를 변경해주세요.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }*/
public void sendEmail(String to, String subject, String code) {
    Context context = new Context();
    context.setVariable("code", code);
    context.setVariable("test", "이거는 test입니다.");

    String htmlContent = templateEngine.process("mail/mail", context);

    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
    try {
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true); // true는 HTML 이메일임을 나타냅니다.
    } catch (MessagingException e) {
        throw new MailParseException(e);
    }
    mailSender.send(mimeMessage);
}

    private String setContext(String code) { // 타임리프 설정하는 코드
        Context context = new Context();
        context.setVariable("code", code); // Template에 전달할 데이터 설정
        context.setVariable("test","이거는 test입니다.");
        return templateEngine.process("mail/mail", context); // mail.html
    }

    public String createCode() {
        int random = (int) (Math.random() * 1000000);
        String code = String.valueOf(random);
        return code;
    }
}
