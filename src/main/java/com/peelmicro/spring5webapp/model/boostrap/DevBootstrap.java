package com.peelmicro.spring5webapp.model.boostrap;

import com.peelmicro.spring5webapp.model.Author;
import com.peelmicro.spring5webapp.model.Book;
import com.peelmicro.spring5webapp.model.Publisher;
import com.peelmicro.spring5webapp.model.repositories.AuthorRepository;
import com.peelmicro.spring5webapp.model.repositories.BookRepository;
import com.peelmicro.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "HarperCollins Publishers - 195 BroadwayNew York, NY 10007");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("Wrox", "Birmingham, England.");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(wrox);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
