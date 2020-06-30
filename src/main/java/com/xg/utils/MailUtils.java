package com.xg.utils;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {

    public static void secdMail(String toMail, String code) throws MessagingException {
        //设置邮件服务器
        Properties properties = new Properties();
        // 开启debug调试
        properties.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        properties.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        properties.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        properties.setProperty("mail.transport.protocol", "smtp");

        //SSL认证，腾讯邮箱是基于SSL加密的，所有需要开启才可以使用
//        MailSSLSocketFactory sf = new MailSSLSocketFactory();
//        sf.setTrustAllHosts(true);
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.ssl.socketFactory", sf);

        //与邮件服务器的连接
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2833679147@qq.com","gedphxhvwgyibfae");
            }
        });

        //创建邮件
        Message message = new MimeMessage(session);
        //设置收件人地址
        message.setFrom(new InternetAddress("2833679147@qq.com"));
        //抄送
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
        //设置邮件的主体
        message.setSubject("来自小瓜的邮件");
        //设置内容
        String msg="<h1>点击<a href='http://localhost:8080/admin/activation.do?code="+code+"'>此处</a>激活账户<h1>";
        message.setContent(msg, "text/html;charset=utf-8");
        //发送邮件
        Transport.send(message);
    }
}

