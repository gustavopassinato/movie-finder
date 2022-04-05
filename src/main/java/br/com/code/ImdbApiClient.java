package br.com.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ImdbApiClient {

	private String apiKey;
	private Parser parser = new Parser();
	private Consumer consumer = new Consumer();
	private HTMLGenerator HtmlGenerator;

	public ImdbApiClient(String apiKey, String htmlName) throws FileNotFoundException {
		this.apiKey = apiKey;
		PrintWriter printWriter = new PrintWriter(new File(htmlName));
		this.HtmlGenerator = new HTMLGenerator(printWriter);
	}

	public String buildHtmlCode(){
		try {
			String json = this.consumer.getMoviesList(this.apiKey);
			
			List<Movie> moviesList = this.parser.parseToMovie(json);
			
			this.HtmlGenerator.generate(moviesList);
		}catch(IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
		return "HTML criado com sucesso";
	}

}
