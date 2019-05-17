package br.com.igor.capitulo1;

import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.List;

public class Java8 {

	public static void main(String[] args) {

		List<Book> allBooks = new ArrayList<>();

		allBooks.add(new Book("Desbravando Java", "Rodrigo Turini"));
		allBooks.add(new Book("APIs Java", "Rodrigo Turini"));
		allBooks.add(new Book("Java 8 Pr�tico", "Rodrigo Turini, Paulo Silveira"));
		allBooks.add(new Book("TDD", "Mauricio Aniche"));
		allBooks.add(new Book("Certifica��o Java", "Guilherme Silveira"));

		// Java 8
		allBooks.stream()
			.filter(book -> book.hasAuthor("Rodrigo Turini"))
			.sorted(comparing(Book::getName))
			.forEach(System.out::println);			
	}

}
