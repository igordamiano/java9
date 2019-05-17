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
		
		// indicou um outro livro da mesma categoria e de outro autor.
		Optional<Book> similar = Books.findSimilar(book);
		System.out.println(similar);
		System.out.println("------------------------------------------------");
		
		// N�o tem livros similares - o c�digo retorna um Optional vazio.
		Book bookSemSimilar = new Book(
				"Guia da Startup",
				"Joaquim Torres",
				Category.BUSINESS
				);
		Optional<Book> semSimilar = Books.findSimilar(bookSemSimilar);
		System.out.println(semSimilar);
		System.out.println("----------------------------------------------------");
		
		// ifPresentOrElse
		if(similar.isPresent()) {
			System.out.println(similar);
		} else {
			System.out.println("N�o existem similares");
		}
	
		if(semSimilar.isPresent()) {
			System.out.println(semSimilar);
		} else {
			System.out.println("N�o existem similares");
		}
		
		System.out.println("----------------------------------");
		// Problema que n�o existe um ELSE
		Books.findSimilar(book).ifPresent(System.out::println);
		
		System.out.println("----------------------------------");
		
		Books.findSimilar(bookSemSimilar).ifPresentOrElse(System.out::println, 
				() -> System.out.println("N�o existem similares"));
		
		Books.findSimilar(book).ifPresentOrElse(System.out::println, 
				() -> System.out.println("N�o existem similares"));
		
		// ***** Optional.stream ***** //
		List<Book> listBooks = List.of(
				new Book(
					"Desbravando Java", 
					"Rodrigo Turini", 
					Category.PROGRAMMING
				),
				new Book(
					"Java 8 Pr�tico", 
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

		// Podemos fazer isso em um stream , que procura seu similar para cada elemento e, ao final, 
		// coleta o resultado para uma nova lista:
		// map
		List<Optional<Book>> similars =
				listBooks.stream()
				.map(Books::findSimilar)
				.collect(Collectors.toList());
		System.out.println("-----------------------------------");
		System.out.println(similars);
		
		// uma lista com apenas os valores v�lidos, logo, poder�amos filtrar os opcionais vazios
		// map e filter
		List<Book> similars1 = 
				listBooks.stream()
				.map(Books::findSimilar)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
		System.out.println("-----------------------------------");
		System.out.println(similars1);
		
		// Com o novo m�todo Optional#stream , agora podemos
		// substituir esse filter e map por um flatMap
		// map e flatMap
		List<Book> similars2 = 
				listBooks.stream()
				.map(Books::findSimilar)
				.flatMap(Optional::stream)
				.collect(Collectors.toList());
		
		System.out.println("-----------------------------------");
		System.out.println(similars2);
		
		// flatMap direto
		// a opera��o de flatten de uma �nica vez
		List<Book> similars3 =
				listBooks.stream()
				.flatMap(b -> Books.findSimilar(b).stream())
				.collect(Collectors.toList());
		
		System.out.println("-----------------------------------");
		System.out.println(similars3);
		
		// Encadeando optionals - or
		Book book1 = new Book(
				"Desbravando Java", 
				"Rodrigo Turini", 
				Category.PROGRAMMING
		);
		
		
		Optional<Book> v = Books.findSimilar(book)
		.or(() -> Books.findSimilar(book)) 
		.or(() -> Books.findSimilar(book1)); 

		System.out.println("-----------or-------------");
		System.out.println(v);
		
		
	}

}
