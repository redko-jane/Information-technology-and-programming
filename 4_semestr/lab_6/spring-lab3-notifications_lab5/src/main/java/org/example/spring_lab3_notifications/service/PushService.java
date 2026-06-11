package org.example.spring_lab3_notifications.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PushService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("PUSH to " + recipient + ": " + message);
    }
}
