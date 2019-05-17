package br.com.igor.capitulo1;

import java.util.List;

import br.com.igor.capitulo3.Category;

public class Book {

	private String name;
	private String author;
	private List<Category> categories;
	
	
	public Book(String name, String author, Category ...categories) {
		this.name = name;
		this.author = author;
		this.categories = List.of(categories);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean hasAuthor(String name) {
		return author.contains(name);
	}

	@Override
	public String toString() {
		return "\n livro: " + name + "\n author: " + author + "\n categorias: " + categories;
	}
	
}
