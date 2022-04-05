package br.com.code;

import java.io.IOException;

public class Teste {

	public static void main(String[] args) throws IOException, InterruptedException {
		String apiKey = "k_xj7sg1f9";
		String htmlFileName = "content.html";
		
		ImdbApiClient client = new ImdbApiClient(apiKey, htmlFileName);
		
		System.out.println(client.buildHtmlCode());
		

	}

}
