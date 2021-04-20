package com.changgou.demo;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
    public static String myEmailAccount = "a994331516@163.com";//邮箱账号
    public static String myEmailPassword = "YAVIJEKMHLWNESFX";//邮箱密码
    public static String myEmailSMTPHost = "smtp.163.com";//发送邮箱服务器地址（这个地址是网易企业邮箱的地址）
    public static void sendEmail(String text,String receiveEmail,String sub,String personal) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        props.setProperty("mail.smtp.auth", "true");
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveEmail,text,sub,personal);
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEmailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }


    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String text,String sub,String personal) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, personal, "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail,"", "UTF-8"));
        message.setSubject(sub, "UTF-8");
        message.setContent(text, "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
    public static void main(String[] args) throws Exception {
        String sub= "邮件发送测试";
        String personal = "测试员007";
        String text = "<h1>你好，林永锋！</h1>" +
                "<p style = 'color:red'>今天是2021年4月19日</p>" +
                "<p style = 'color:green'>我们已经在森林里面迷失3个月了</p>";
        sendEmail(text,"no.1lyf@qq.com",sub,personal);
    }
}
