package com.southsystem.fileprocessor.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BrokerOutput {

    String FILE_PROCESSOR = "fileProcessor";

    @Output(BrokerOutput.FILE_PROCESSOR)
    MessageChannel fileProcessorQueue();
}
