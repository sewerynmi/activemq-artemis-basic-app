package com.severinu.artemisdemo.dto;

import lombok.Data;

@Data
public class MessageToQueueDTO {
    private final String queue;
    private final String message;
}
