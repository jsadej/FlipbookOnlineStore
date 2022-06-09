package com.example.flipbook.catalog.infrastructure;

import com.example.flipbook.catalog.domain.Book;
import com.example.flipbook.catalog.domain.CatalogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
class MemoryCatalogRepository implements CatalogRepository {


    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong ID_Next_Value = new AtomicLong(0);


    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Book save(Book book) {
        if(book.getId()!=null){
            storage.put(book.getId(),book);
        }
        else {
            long nextId = nextID();
            book.setId(nextId);
            storage.put(nextId, book);
        }
      return  book;

    }

    @Override
    public Optional<Book> findByID(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void removeById(Long id) {
        storage.remove(id);
    }

    private long nextID() {
        return ID_Next_Value.getAndIncrement();

    }
}



