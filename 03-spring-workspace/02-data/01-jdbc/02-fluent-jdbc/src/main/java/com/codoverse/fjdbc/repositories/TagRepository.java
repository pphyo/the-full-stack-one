package com.codoverse.fjdbc.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.codoverse.fjdbc.models.Tag;

public interface TagRepository extends ListCrudRepository<Tag, Long> {

}
