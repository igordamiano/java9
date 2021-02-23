package br.com.igor.capitulo3;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.igor.capitulo1.Book;

public class OptionalsExercicios {

	public static void main(String[] args) {

		Book book = new Book(
			"Desbravando Java",
			"Rodrigo Turini",
			Category.PROGRAMMING	
		);
		
		System.out.println("* 0 ------------------------------------------------");
		// indicou um outro livro da mesma categoria e de outro autor.
		Optional<Book> similar = Books.findSimilar(book);
		System.out.println(similar);
		
		System.out.println("* 1 ------------------------------------------------");
		// Não tem livros similares - o código retorna um Optional vazio.
		Book bookSemSimilar = new Book(
				"Guia da Startup",
				"Joaquim Torres",
				Category.BUSINESS
				);
		Optional<Book> semSimilar = Books.findSimilar(bookSemSimilar);
		System.out.println(semSimilar);
		
		System.out.println("* 2 ------------------------------------------------");
		// ifPresentOrElse
		if(similar.isPresent()) {
			System.out.println(similar);
		} else {
			System.out.println("Não existem similares");
		}
	
		System.out.println("* 3 ------------------------------------------------");
		if(semSimilar.isPresent()) {
			System.out.println(semSimilar);
		} else {
			System.out.println("Não existem similares");
		}
		
		System.out.println("* 4 ------------------------------------------------");
		// Problema que não existe um ELSE
		Books.findSimilar(book).ifPresent(System.out::println);
		
		System.out.println("* 5 ------------------------------------------------");
		Books.findSimilar(bookSemSimilar).ifPresentOrElse(System.out::println, 
				() -> System.out.println("Não existem similares"));
		
		System.out.println("* 6 ------------------------------------------------");
		Books.findSimilar(book).ifPresentOrElse(System.out::println, 
				() -> System.out.println("Não existem similares"));
		
		// ***** Optional.stream ***** //
		List<Book> listBooks = List.of(
				new Book(
					"Desbravando Java", 
					"Rodrigo Turini", 
					Category.PROGRAMMING
				),
				new Book(
					"Java 8 Prático", 
					"Paulo Silveira", 
					Category.PROGRAMMING
				),
				new Book(
					"SOLID", 
					"Mauricio Aniche", 
					Category.PROGRAMMING
				),
				new Book(
					"Guia da Startup", 
					"Joaquim Torres", 
					Category.BUSINESS
				)
			);

		System.out.println("* 7 ------------------------------------------------");
		// Podemos fazer isso em um stream , que procura seu similar para cada elemento e, ao final, 
		// coleta o resultado para uma nova lista:
		// map
		List<Optional<Book>> similars =
				listBooks.stream()
				.map(Books::findSimilar)
				.collect(Collectors.toList());
		System.out.println(similars);
		
		System.out.println("* 8 ------------------------------------------------");
		// uma lista com apenas os valores válidos, logo, poderíamos filtrar os opcionais vazios
		// map e filter
		List<Book> similars1 = 
				listBooks.stream()
				.map(Books::findSimilar)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
		System.out.println(similars1);
		
		System.out.println("* 9 ------------------------------------------------");
		// Com o novo método Optional#stream , agora podemos
		// substituir esse filter e map por um flatMap
		// map e flatMap
		List<Book> similars2 = 
				listBooks.stream()
				.map(Books::findSimilar)
				.flatMap(Optional::stream)
				.collect(Collectors.toList());
		System.out.println(similars2);
		
		System.out.println("* 10 ------------------------------------------------");
		// flatMap direto
		// a operação de flatten de uma única vez
		List<Book> similars3 =
				listBooks.stream()
				.flatMap(b -> Books.findSimilar(b).stream())
				.collect(Collectors.toList());
		System.out.println(similars3);
		
		System.out.println("* 11 ---------------------OR---------------------------");
		// Encadeando optionals - or
		Book book1 = new Book(
				"Desbravando Java", 
				"Rodrigo Turini", 
				Category.PROGRAMMING
		);
		
		Optional<Book> v = Books.findSimilar(book)
		.or(() -> Books.findSimilar(book)) 
		.or(() -> Books.findSimilar(book1)); 
		System.out.println(v);
		
		
	}

}
