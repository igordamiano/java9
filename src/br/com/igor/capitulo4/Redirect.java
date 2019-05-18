package br.com.igor.capitulo4;

import java.net.URI;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class Redirect {

	public static void main(String[] args) throws Exception {

		String content = HttpClient.newHttpClient()
				.send(HttpRequest.newBuilder().uri(new URI("https://google.com/"))
						.GET().build(), 
						HttpResponse.BodyHandler.asString()).body();
		
		System.out.println(content);
		System.out.println("--------------------------------------------------------");

		String content1 = HttpClient.newBuilder()
			.followRedirects(HttpClient.Redirect.SECURE)
			.version(HttpClient.Version.HTTP_2)
			.build()
			.send(HttpRequest.newBuilder()
					.uri(new URI("https://google.com/"))
					.GET()
					.build(), 
					HttpResponse.BodyHandler.asString()).body();
		
		System.out.println(content1);
		
		


		
		
		
		
		
	}

}
