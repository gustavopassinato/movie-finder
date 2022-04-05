package br.com.code;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consumer {
	
	private String ACCESS_LINK = "https://imdb-api.com/en/API/Top250Movies/";
	
	public String getMoviesList(String apiKey) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		
		String AccessLinkWithKey = ACCESS_LINK + apiKey;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(AccessLinkWithKey)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}
}
