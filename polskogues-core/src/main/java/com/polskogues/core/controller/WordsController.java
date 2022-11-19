package com.polskogues.core.controller;


import com.polskogues.core.resources.Content;
import com.polskogues.core.resources.Contents;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WordsController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/contents")
    public Contents contents() {
        return new Contents(counter.incrementAndGet(),
                Arrays.asList(
                        new Content(1, "czesc", "oi"),
                        new Content(2, "dzien dobry", "bom dia")));
    }
}
