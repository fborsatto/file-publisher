package com.southsystem.fileprocessor.resource;

import com.southsystem.fileprocessor.service.FilePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class FilePublisherResource {

    @Autowired
    private FilePublisherService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/start")
    public Mono<Void> start() {
        return Mono.just(service.readDirectory());
    }
}
