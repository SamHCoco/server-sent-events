package com.samhcoco.sse.kafka;

import com.samhcoco.sse.controller.ServerSentEventController;
import com.samhcoco.sse.model.ServerSentEventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ServerSentEventConsumer {

    private final ServerSentEventController serverSentEventController;

    @KafkaListener(topics = "server-sent-events",
                   groupId = "server-sent-events-group")
    public void consume(ServerSentEventMessage message) {
        log.info("ATTEMPTING TO SEND SSE: {}", message);
        serverSentEventController.send(message);
    }

}
