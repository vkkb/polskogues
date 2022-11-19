package com.polskogues.core.controller;


import com.polskogues.core.ContentRepository;
import com.polskogues.core.model.Contents;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WordsController {

    private final ContentRepository contentRepository;

    private final AtomicLong counter = new AtomicLong();

    public WordsController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("/contents")
    public Contents contents() {
        return new Contents(counter.incrementAndGet(), contentRepository.findAll());
    }
}
