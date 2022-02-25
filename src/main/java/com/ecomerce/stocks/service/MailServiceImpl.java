package com.ecomerce.stocks.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MailServiceImpl implements MailService{

    private static final String FROM = "indersahota112@gmail.com";
    private static final String USERNAME = "indersahota112@gmail.com";
    private static final String PASSWORD = "*******Password***";

    /**
     * Comma separated Email-Id's
     */
    private static final String DEFAULT_DEV_SUPPORT_TEAM_EMAILS = "beancoderoj@gmail.com,indersahota112@gmail.com";

    private static final String HOST = "smtp.gmail.com";

    @Override
    public void sendMail(String to, String subject, String content)
    {

        Session session = getSession();

        try
        {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(FROM));

            // Set To: header field of the header.
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(content);

            // Send message
            Transport.send(message);


        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }

    private Session getSession()
    {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(
                props,
                new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
        return session;
    }

    @Override
    public void sendMail(String sendTo, String message)
    {

        StringBuilder messageBuilder = new StringBuilder("UD Message");



        sendMail(sendTo, "Mail- SUBJECT", messageBuilder.toString());
    }

}
