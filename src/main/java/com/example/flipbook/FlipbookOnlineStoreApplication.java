package com.example.flipbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FlipbookOnlineStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlipbookOnlineStoreApplication.class, args);
	}
	private final  CatalogServices catalogServices;

	public FlipbookOnlineStoreApplication(CatalogServices catalogServices) {
		this.catalogServices = catalogServices;
	}

	@Override
	public void run(String... args)  {
		//CatalogServices catalogServices = new CatalogServices();
		List<Book> books=catalogServices.findByTitle("Pan Tadeusz");
		books.forEach(System.out::println);
	}
}
