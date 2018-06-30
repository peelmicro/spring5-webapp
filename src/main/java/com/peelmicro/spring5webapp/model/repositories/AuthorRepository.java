package com.peelmicro.spring5webapp.model.repositories;

import com.peelmicro.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
