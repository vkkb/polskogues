package com.polskogues.core;

import com.polskogues.core.model.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DatabaseConfig {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

    private static final List<Content> CONTENTS = Arrays.asList(
            new Content(1, "czesc", "oi"),
            new Content(2, "dzien dobry", "bom dia")
    );

    @Bean
    CommandLineRunner loadDatabase(ContentRepository contentRepository) {
        return args -> {
            log.info("Loading data: " + contentRepository.saveAll(CONTENTS));
        };
    }
}