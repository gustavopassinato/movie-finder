package br.com.code;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Teste {
	
	private static String URL = "https://imdb-api.com/en/API/SearchMovie/k_xj7sg1f9/inception%2010";
	
	public static void main(String[] args) {
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(URL))
				.GET()
				.build();
		
		
		client.sendAsync(request, BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
		.thenAccept(System.out::println)
		.join();
	}

}
