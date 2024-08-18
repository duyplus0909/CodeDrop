package com.codedrop.service.impl;

import com.codedrop.dto.MailDto;
import com.codedrop.service.MailerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;
import java.util.Queue;

@Service
public class MailerServiceImpl implements MailerService {

    Queue<MailDto> queue = new PriorityQueue<>();

    @Autowired
    JavaMailSender sender;

    @Override
    public void send(MailDto mail) {
        MimeMessagePreparator mmp = (mimeMessage) -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mail.prepareToSend(message);
        };
        sender.send(mmp);
    }

    @Override
    public void send(String to, String subject, String body) {
        send(new MailDto(to, subject, body));
    }

    @Override
    public void queue(MailDto mail) {
        queue.offer(mail);
    }

    @Override
    public void queue(String to, String subject, String body) {
        queue(new MailDto(to, subject, body));
    }

    @Scheduled(fixedDelay = 5000)
    @SneakyThrows
    public void run() {
        while (!queue.isEmpty()) send(queue.poll());
    }
}
