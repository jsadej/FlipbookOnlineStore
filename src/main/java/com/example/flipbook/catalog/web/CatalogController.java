package com.example.flipbook.catalog.web;

import com.example.flipbook.catalog.application.port.CatalogUseCase;
import com.example.flipbook.catalog.domain.Book;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/catalog")
@RestController
@AllArgsConstructor
class CatalogController {
    private final CatalogUseCase catalog;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book>getAll(

            @RequestParam Optional<String> title,
            @RequestParam Optional<String> author ) {

        if (title.isPresent() && author.isPresent()) {
            return catalog.findByTitleAndAuthor(title.get(), author.get());

        } else if (title.isPresent()) {
            return catalog.findByTitle(title.get());

        } else if (author.isPresent()) {

            return catalog.findByAuthor(author.get());
        }


        return catalog.findAll();

    }

    @GetMapping("/{id}")

    public ResponseEntity<Book> getId(@PathVariable Long id){


        return  catalog
                .findById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
    }
}