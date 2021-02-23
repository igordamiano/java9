package br.com.igor.capitulo4;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ResponseAsFile {
	
	private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

	public static void main(String[] args) throws Exception {

		String url = "https://turini.github.io/livro-java-9/books.csv";
		
		HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        CompletableFuture<HttpResponse<Path>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofFile(Paths.get("books.csv")));

        Path result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        System.out.println(result.toAbsolutePath());
	}

}
