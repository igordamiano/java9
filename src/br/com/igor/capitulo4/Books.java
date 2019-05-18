package br.com.igor.capitulo4;

import java.net.URI;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class Books {

	public static void main(String[] args) throws Exception {

		String csv = HttpClient.newHttpClient()
				.send(HttpRequest.newBuilder().uri(new URI("https://turini.github.io/livro-java-9/books.csv"))
						.GET().build()
						, HttpResponse.BodyHandler.asString()).body();
		
		System.out.println(csv);
		
		
	}

}
