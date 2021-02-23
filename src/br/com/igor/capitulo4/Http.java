package br.com.igor.capitulo4;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {

	public static void main(String[] args) throws Exception {

		//URI uri = new URI("https://github.com/igordamiano/java9/");
		URI uri = new URI("https://turini.github.io/livro-java-9/"); //  HTTP_2
		//URI uri = new URI("https://www.irdbr.com.br/"); //HTTP_1_1

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

		//HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandler.asString());
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("* 0 ----------------------------------------------------");
		System.out.println("http version: " + response.version());
		System.out.println("status code: " + response.statusCode());
		System.out.println("content: " + response.body());
		
		// encadeado 
		// Com essa nova possibilidade, conseguimos fazer requisições HTTP de forma nativa e bastante eficiente, 
		// sem depender de bibliotecas externas e tirando bastante proveito dos recursos da
		// linguagem em uma API amigável.
		HttpResponse<String> responses = HttpClient.newHttpClient().send(
				HttpRequest.newBuilder().uri(new URI("https://turini.github.io/livro-java-9/"))
				.GET().build()
				,//HttpResponse.BodyHandler.asString());
				HttpResponse.BodyHandlers.ofString());
		
		System.out.println("* 1 ----------------------------------------------------");
		System.out.println(responses);
		
	}
}