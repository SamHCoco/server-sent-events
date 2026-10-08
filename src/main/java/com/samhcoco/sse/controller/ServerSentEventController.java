package com.samhcoco.sse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ServerSentEventController {

    @GetMapping(path = "events")
    public SseEmitter serverSentEvents() {
        try {
            final SseEmitter emitter = new SseEmitter();
            String successMessage = "Hello world, from server!";
            emitter.send(successMessage);
            return emitter;
        } catch (IOException e) {
            log.error("Failed to send Server Event: {}", e.getMessage());
            return null;
        }
    }


}
