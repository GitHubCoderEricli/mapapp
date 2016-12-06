package com.huashan.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    /**
     * 发送邮件主机
     */
    private String host;

    /**
     * 收件人邮箱，以分号隔开
     */
    private String toEmails;

    /**
     * 发件人用户名
     */
    private String fromUserName;
    /**
     * 发件人密码
     */
    private String password;
    /**
     * 发送内容
     */
    private String text;
    /**
     * 发送主题
     */
    private String Subject;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getToEmails() {
        return toEmails;
    }

    public void setToEmails(String toEmails) {
        this.toEmails = toEmails;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }


    public void sendMail() throws MessagingException {
        /*JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 添加验证

        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(fromUserName, password); //发件人邮件用户名、密码
            }
        });

        // 设定mail server
        senderImpl.setHost("smtp.coocaa.com");

        // 创建默认的 MimeMessage 对象
        MimeMessage message = new MimeMessage(session);

        // Set From: 头部头字段
        message.setFrom(new InternetAddress(fromUserName));

        // Set To: 头部头字段
        InternetAddress[] parse = InternetAddress.parse(toEmails);
            *//*message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));*//*
        message.addRecipients(Message.RecipientType.TO, parse);

        // Set Subject: 头部头字段
        message.setSubject(Subject);

        // 设置消息体
        message.setText(text);

        senderImpl.setSession(session);

        // 发送邮件
        senderImpl.send(message);
        System.out.println("Sent message successfully....");*/

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(fromUserName, password); //发件人邮件用户名、密码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(fromUserName));

            // Set To: 头部头字段
            InternetAddress[] parse = InternetAddress.parse(toEmails);
            message.addRecipients(Message.RecipientType.TO,parse);

            // Set Subject: 头部头字段
            message.setSubject(Subject);

            // 设置消息体
            message.setText(text);

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
