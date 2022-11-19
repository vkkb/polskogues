package com.polskogues.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    @Id
    @GeneratedValue
    private long id;

    private String polishContent;

    private String portugueseContent;
}