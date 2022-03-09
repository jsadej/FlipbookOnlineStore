package com.example.flipbook;

import com.example.flipbook.catalog.application.CatalogController;
import com.example.flipbook.catalog.domain.Book;
import com.example.flipbook.catalog.domain.CatalogServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FlipbookOnlineStoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(FlipbookOnlineStoreApplication.class, args);
	}


}
