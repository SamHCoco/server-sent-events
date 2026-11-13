package com.samhcoco.sse.kafka;

import com.samhcoco.sse.controller.ServerSentEventController;
import com.samhcoco.sse.model.ServerSentEventMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServerSentEventConsumer {

    private final ServerSentEventController serverSentEventController;

    @KafkaListener(topics = "server-sent-events")
    public void consume(ServerSentEventMessage message) {
        serverSentEventController.send(message);
    }

}
