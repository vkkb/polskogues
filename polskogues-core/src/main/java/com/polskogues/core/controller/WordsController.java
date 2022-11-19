package com.polskogues.core.controller;


import com.polskogues.core.ContentRepository;
import com.polskogues.core.exception.ContentNotFoundException;
import com.polskogues.core.model.Content;
import com.polskogues.core.model.ContentModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class WordsController {

    private final ContentRepository contentRepository;

    private final ContentModelAssembler contentModelAssembler;

    private final AtomicLong counter = new AtomicLong();

    public WordsController(ContentRepository contentRepository, ContentModelAssembler contentModelAssembler) {
        this.contentRepository = contentRepository;
        this.contentModelAssembler = contentModelAssembler;
    }

    @GetMapping("/contents")
    public CollectionModel<EntityModel<Content>> contents() {
        List<EntityModel<Content>> contents = contentRepository.findAll().stream()
                .map(contentModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(contents, linkTo(methodOn(WordsController.class).contents()).withSelfRel());
    }

    @GetMapping("/contents/{id}")
    public EntityModel<Content> content(@PathVariable Long id) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException(id));
        return contentModelAssembler.toModel(content);
    }
}