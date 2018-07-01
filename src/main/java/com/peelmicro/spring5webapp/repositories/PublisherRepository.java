package com.peelmicro.spring5webapp.repositories;

import com.peelmicro.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
