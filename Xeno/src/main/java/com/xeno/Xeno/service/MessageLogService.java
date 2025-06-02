package com.xeno.Xeno.service;

import com.xeno.Xeno.model.MessageLog;
import com.xeno.Xeno.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageLogService {

    @Autowired
    private MessageLogRepository messageLogRepository;

    // Save or update a message log
    public MessageLog saveMessageLog(MessageLog messageLog) {
        return messageLogRepository.save(messageLog);
    }

    // Get all message logs
    public List<MessageLog> getAllMessageLogs() {
        return messageLogRepository.findAll();
    }

    // Get a message log by ID
    public Optional<MessageLog> getMessageLogById(Long id) {
        return messageLogRepository.findById(id);
    }

    // Delete a message log by ID
    public void deleteMessageLog(Long id) {
        messageLogRepository.deleteById(id);
    }
}
