package br.com.igor.capitulo1;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {

		Optional<String> author = Optional.ofNullable("Rodrigo Turini, Paulo Silveira");
		
		boolean hasAuthor = author
				.filter(s -> s.contains("Rodrigo Turini, Paulo Silveira"))
				.isPresent();
		
		System.out.println(hasAuthor);
		
		
	}

}
