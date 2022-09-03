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

    /**
     * This one will send message to the default queue aka ${jms.queue} configured in the properties file
     * @param message String
     */
    public void sendMessage (String message) {
        jmsTemplate.convertAndSend(jmsQueue, message);
    }

    /**
     * This one allows passing queue name for the message.
     * @param queue String Queue name as string
     * @param message String Message text
     */
    public void sendMessage (String queue, String message) {
        jmsTemplate.convertAndSend(queue, message);
    }

}
