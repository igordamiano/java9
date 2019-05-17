package br.com.igor.capitulo4;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Redirect {

	public static void main(String[] args) throws Exception {

		String content = HttpClient.newHttpClient()
				.send(HttpRequest.newBuilder().uri(new URI("https://google.com/"))
						.GET().build(), 
						HttpResponse.BodyHandlers.ofString()).body();
		
		System.out.println(content);
		System.out.println("--------------------------------------------------------");

		String content1 = HttpClient.newBuilder()
			.followRedirects(HttpClient.Redirect.NORMAL)
			.version(HttpClient.Version.HTTP_2)
			.build()
			.send(HttpRequest.newBuilder()
					.uri(new URI("https://google.com/"))
					.GET()
					.build(), 
					HttpResponse.BodyHandlers.ofString()).body();
		
		System.out.println(content1);
		
		


		
		
		
		
		
	}

}
