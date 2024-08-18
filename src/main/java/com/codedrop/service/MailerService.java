package com.codedrop.service;

import com.codedrop.dto.MailDto;
import jakarta.mail.MessagingException;

public interface MailerService {

    void send(MailDto mail) throws MessagingException;

    void send(String to, String subject, String body) throws MessagingException;

    void queue(MailDto mail);

    void queue(String to, String subject, String body);
}
