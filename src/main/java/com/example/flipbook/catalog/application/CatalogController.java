package com.example.flipbook.catalog.application;

import com.example.flipbook.catalog.domain.Book;
import com.example.flipbook.catalog.domain.CatalogServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CatalogController {
    private  final CatalogServices services;

    public List<Book> findByTitle(String title) {
    return services.findByTitle(title);
    }

}
