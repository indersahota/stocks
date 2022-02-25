package com.ecomerce.stocks.service;

public interface MailService {
    void sendMail(String sendTo, String message);

    public void sendMail(String to, String subject, String content);
}
