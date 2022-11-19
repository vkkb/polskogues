package com.polskogues.core.model;

import lombok.Value;

import java.util.List;

@Value
public class Contents {

    private final long id;

    private final List<Content> contents;
}