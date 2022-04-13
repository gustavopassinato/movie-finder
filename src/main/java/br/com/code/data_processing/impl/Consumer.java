package br.com.code.data_processing.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consumer {
	
	public String getMoviesList(String apiFullAccessLink) throws IOException, InterruptedException {
		if(apiFullAccessLink.isBlank()) {
			throw new IllegalArgumentException("The access link to the API is invalid!");
		}
		HttpClient client = HttpClient.newHttpClient();
		
		String AccessLinkWithKey = apiFullAccessLink;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(AccessLinkWithKey)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}
}
