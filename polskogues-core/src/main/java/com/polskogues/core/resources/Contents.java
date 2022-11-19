package com.polskogues.core.resources;

import lombok.Value;

import java.util.List;

@Value
public class Contents {

    private final long id;

    private final List<Content> contents;
}
