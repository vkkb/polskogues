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
            new Content(2, "dzien dobry", "bom dia"),
            new Content(3, "dobrze", "bom"),
            new Content(4, "piwo", "cerveja"),
            new Content(5, "do widzenia", "adeus"),
            new Content(6, "dziekuje", "obrigado"),
            new Content(7, "prosze", "por favor"),
            new Content(8, "co", "o que"),
            new Content(9, "kocham cie", "te amo"),
            new Content(10, "zmeczony", "cansado"),
            new Content(11, "wino", "vinho"),
            new Content(12, "przytulic", "abraçar"),
            new Content(13, "chlopak", "namorado"),
            new Content(14, "dziewczyna", "namorada"),
            new Content(15, "syn", "filho"),
            new Content(16, "corka", "filha"),
            new Content(17, "serce", "coração")
    );

    @Bean
    CommandLineRunner loadDatabase(ContentRepository contentRepository) {
        return args -> {
            log.info("Loading data: " + contentRepository.saveAll(CONTENTS));
        };
    }
}