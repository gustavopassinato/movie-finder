package br.com.code;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DiaUm {

	private static String accessToken = "k_xj7sg1f9";
	private static String URL = "https://imdb-api.com/en/API/Top250Movies/" + accessToken;

	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response);
		
		String jsonResponse = response.body();
		
		System.out.println(jsonResponse);
	}

}
