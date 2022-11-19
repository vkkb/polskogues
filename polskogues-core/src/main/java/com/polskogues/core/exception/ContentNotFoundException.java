package com.polskogues.core.exception;

public class ContentNotFoundException extends RuntimeException {
    public ContentNotFoundException(Long id) {
        super("No content found for ID " + id);
    }
}