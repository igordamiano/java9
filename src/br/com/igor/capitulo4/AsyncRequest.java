package br.com.igor.capitulo4;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncRequest {

	public static void main(String[] args) throws Exception {

		CompletableFuture<HttpResponse<String>> response =
				HttpClient.newHttpClient()
				.sendAsync(HttpRequest.newBuilder()
						.uri(new URI("https://turini.github.io/livro-java-9/books.csv")).GET().build(), 
						//HttpResponse.BodyHandler.asString());
						HttpResponse.BodyHandlers.ofString());

		
		// Com esse CompletableFuture em mãos, poderíamos, por exemplo, perguntar logo em seguida
		// se ele está pronto com seu método isDone . Se estiver, imprimimos a saída; caso contrário,
		// cancelamos sua execução
		if (response.isDone()) {
			System.out.println(response.get().body());
		} else {
			System.out.println("Cancelando o request");
			//response.cancel(true);
		}
		
		//
		System.out.println("------------------------------------------------");
		HttpClient.newHttpClient()
		.sendAsync(HttpRequest.newBuilder()
				.uri(new URI("https://turini.github.io/livro-java-9/books.csv")).GET().build(), 
				HttpResponse.BodyHandlers.ofString())
			.whenComplete((r, t) -> System.out.println(r.body()));
		
	}

}
