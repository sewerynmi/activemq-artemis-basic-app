package com.severinu.artemisdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverService {

    Logger log = LoggerFactory.getLogger(ReceiverService.class);

    @JmsListener(destination = "${jms.queue}")
    public void receiveMessage(String message) {
        log.info("Received message: " + message);
    }

    @JmsListener(destination = "${jms.otherQueue}")
    public void receiveMessageOnOtherQueue(String message) {
        log.info("Received message on Other Queue : " + message);
    }

}
