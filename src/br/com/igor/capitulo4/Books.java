package br.com.igor.capitulo4;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.igor.capitulo1.Book;
import br.com.igor.capitulo3.Category;

public class Books {

	public static void main(String[] args) throws Exception {

		String csv = HttpClient.newHttpClient()
				// send() funciona de forma totalmente síncrona. Ele bloqueia o código até que a resposta esteja completa
				.send(HttpRequest.newBuilder().uri(new URI("https://turini.github.io/livro-java-9/books.csv"))
						.GET().build()
						, HttpResponse.BodyHandlers.ofString()).body();
		
		System.out.println("* 0 --------------------------------------------------------");
		System.out.println(csv);
		
		List<Book> listCsv = Stream.of(csv.split("\n"))
			.map(Books::create)
			.collect(Collectors.toList());
		
		//listCsv.forEach(System.out::println);
		
		//Books.all().forEach(System.out::println);
		// Imprimir o nome de cada livro
		System.out.println("* 1 --------------------------------------------------------");
		Books.all().stream().map(Book::getName).forEach(System.out::println);
		
		
	}
	
	public static Book create(String line) {
		String[] split = line.split(",");
		
		String name = split[0];
		String author = split[2];
		
		Category category = Category.valueOf(split[3]);
		
		return new Book(name, author, category);
		
	}
	
	public static List<Book> all() {
		
		String csv = null;
		try {
			csv = HttpClient.newHttpClient()
					.send(HttpRequest.newBuilder().uri(new URI("https://turini.github.io/livro-java-9/books.csv"))
							.GET().build()
							, HttpResponse.BodyHandlers.ofString()).body();
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível conectar", e);
		} 		

		return Stream.of(csv.split("\n"))
				.map(Books::create)
				.collect(Collectors.toList());
		
	}
	

}
