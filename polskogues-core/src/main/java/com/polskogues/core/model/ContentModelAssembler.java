package com.polskogues.core.model;

import com.polskogues.core.controller.WordsController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ContentModelAssembler implements RepresentationModelAssembler<Content, EntityModel<Content>> {

    @Override
    public EntityModel<Content> toModel(Content content) {
        return EntityModel.of(content,
                linkTo(methodOn(WordsController.class).content(content.getId())).withSelfRel(),
                linkTo(methodOn(WordsController.class).contents()).withRel("contents"));
    }
}