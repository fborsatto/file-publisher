package com.southsystem.filepublisher.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.southsystem.filepublisher.config.BrokerOutput;
import com.southsystem.filepublisher.dto.ProcessFileRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private BrokerOutput brokerOutput;

    public void sendFileToQueue(List<String> lines, String path) {
        try {
            ProcessFileRequestDTO processFileRequestDTO = new ProcessFileRequestDTO(lines, path);
            ObjectMapper mapper = new ObjectMapper();
            Message message = MessageBuilder.withPayload(mapper.writeValueAsBytes(processFileRequestDTO)).build();
            brokerOutput.fileProcessorQueue().send(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
