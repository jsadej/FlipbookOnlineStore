package com.example.flipbook.catalog.application;


import com.example.flipbook.catalog.application.port.CatalogUseCase;
import com.example.flipbook.catalog.domain.Book;
import com.example.flipbook.catalog.domain.CatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

 class CatalogServices implements CatalogUseCase {

  private  final CatalogRepository repository;



@Override
public List<Book>findByTitle(String title) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .collect(Collectors.toList());

    }


    @Override
    public List<Book> findByAuthor(String author) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getAuthor().startsWith(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll(){
        return  null;
}
    @Override
    public Optional<Book> findOneByTitleAndAuthor(String title, String author){
        return  Optional.empty();
    }
    @Override
    public  void addBook(CreateBookCommand command){
    Book book = new Book(command.getTitle(),command.getAuthor(),command.getYear());
     repository.save(book);
    }
    @Override
    public  void removeById(Long id){

    }
    @Override
    public void updateBook(){

    }
    }

