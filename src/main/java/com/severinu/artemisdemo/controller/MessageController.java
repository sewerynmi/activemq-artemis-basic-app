package com.severinu.artemisdemo.controller;

import com.severinu.artemisdemo.dto.MessageToQueueDTO;
import com.severinu.artemisdemo.service.DispatcherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final DispatcherService dispatcherService;

    public MessageController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> send (@RequestBody String message) {
        dispatcherService.sendMessage(message);
        return new ResponseEntity<>("Message set: " + message, HttpStatus.OK);
    }

    @PostMapping("/sendtoqueue")
    public ResponseEntity<String> sendToQueue (@RequestBody MessageToQueueDTO messageToQueueDTO) {
        dispatcherService.sendMessage(messageToQueueDTO.getQueue(), messageToQueueDTO.getMessage());
        return new ResponseEntity<>("Message to queue : " + messageToQueueDTO.getQueue() + " set with txt:" +
                messageToQueueDTO.getMessage(), HttpStatus.OK);
    }
}
