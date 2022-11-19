package com.polskogues.core.resources;

import lombok.Value;

@Value
public class Content {

    private final long id;

    private final String polishContent;

    private final String portugueseContent;
}