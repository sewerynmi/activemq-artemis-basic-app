package com.severinu.artemisdemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class DispatcherService {

    private final JmsTemplate jmsTemplate;

    @Value("${jms.queue}")
    String jmsQueue;

    public DispatcherService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage (String message) {
        jmsTemplate.convertAndSend(jmsQueue, message);
    }

}
