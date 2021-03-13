package com.bibliotheek.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class BaseJpaEntity {
    @Id
    @GeneratedValue
    protected Long id;
}
