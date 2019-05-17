package br.com.igor.capitulo3;

import java.util.List;
import java.util.Optional;

import br.com.igor.capitulo1.Book;

public class Books {

	public static List<Book> all() {

		return List.of(new Book("Desbravando Java", "Rodrigo Turini", Category.PROGRAMMING),
				new Book("APIs Java", "Rodrigo Turini", Category.PROGRAMMING),
				new Book("Certificação Java", "Guilherme Silveira", Category.PROGRAMMING, Category.CERTIFICATION),
				new Book("TDD", "Mauricio Aniche", Category.PROGRAMMING, Category.AGILE),
				new Book("SOLID", "Mauricio Aniche", Category.PROGRAMMING),
				new Book("Guia da Startup", "Joaquim Torres", Category.BUSINESS));
	}
	
	// dada uma categoria, quero qualquer livro que pertença a ela.
	public static Optional<Book> findSimilar(Book book){
		
		return Books.all().stream()
				.filter(b -> b.getCategories().equals(book.getCategories()))
				.filter(b -> !b.getAuthor().equals(book.getAuthor()))
				.findAny();
	}
	

}
