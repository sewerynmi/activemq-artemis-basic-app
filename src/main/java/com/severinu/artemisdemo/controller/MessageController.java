package com.severinu.artemisdemo.controller;

import com.severinu.artemisdemo.dto.MessageToQueueDTO;
import com.severinu.artemisdemo.responses.UploadFileResponse;
import com.severinu.artemisdemo.service.DispatcherService;
import com.severinu.artemisdemo.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/message")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final DispatcherService dispatcherService;
    private final FileStorageService fileStorageService;

    public MessageController(DispatcherService dispatcherService, FileStorageService fileStorageService) {
        this.dispatcherService = dispatcherService;
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/send/file")
    public UploadFileResponse sendFile (@RequestParam("file") MultipartFile file) {
        logger.info("Calling method sendFile");
        String fileName = fileStorageService.storeFile(file);
        logger.info("Attempt to upload file with name: " + fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
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
