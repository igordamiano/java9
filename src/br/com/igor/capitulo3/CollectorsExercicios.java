package br.com.igor.capitulo3;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.igor.capitulo1.Book;

public class CollectorsExercicios {

	public static void main(String[] args) {

		// imprime todos os livros
		Books.all().forEach(System.out::println);
		System.out.println("----------------------------------------------------------");
		
		// Agrupar livros por autor, filtrando a categoria programação. Usando groupingBy
		// filter
		Books.all().stream().filter(b -> b.getCategories().contains(Category.PROGRAMMING))
			.collect(Collectors.groupingBy(Book::getAuthor));
		
		// Collectors.filtering
		Books.all().stream()
			.collect(Collectors.groupingBy(Book::getAuthor, Collectors.filtering
					(b -> b.getCategories().contains(Category.PROGRAMMING), Collectors.toList())));
		
		// Collectors.mapping
		// agrupar os livros por seus autores
		// mostrando apenas as categorias que cada autor já escreveu
		Books.all().stream()
			.collect(Collectors.groupingBy(Book::getAuthor,
					Collectors.mapping(Book::getCategories, 
							Collectors.toList())));
		
		// Nos dois acima a categoria se repete
		// Ao usar uma lista, usar um Set
		// Collectors.mapping sem duplicacao, com toSet
		Books.all().stream().collect(Collectors.groupingBy(Book::getAuthor,
				Collectors.mapping(Book::getCategories, 
						Collectors.toSet())));
		
		// map de set de list
		Map<String, Set<List<Category>>> map = Books.all().stream().collect(Collectors.groupingBy(Book::getAuthor,
				Collectors.mapping(Book::getCategories, 
						Collectors.toSet())));
		
		System.out.println(map);
		System.out.println("--------------------------------");
		//Collectors.flatMapping
		
		//flatMapping . Ele funciona de forma análoga ao flatMap do Stream, que permite achatar os elementos de
		// várias listas dentro de uma única coleção.
		Map<String, Set<Category>> map1 = Books.all().stream()
			.collect(Collectors.groupingBy(Book::getAuthor,
					Collectors.flatMapping(b -> b.getCategories().stream(), 
							Collectors.toSet())));
		System.out.println(map1);
		
		
		
	}

}
