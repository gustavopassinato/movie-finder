package br.com.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.code.data_processing.impl.Consumer;
import br.com.code.data_processing.impl.HTMLGenerator;
import br.com.code.data_processing.impl.Parser;
import br.com.code.model.Movie;

public class ImdbApiClient {

	private final String ACCESS_LINK = "https://imdb-api.com/en/API/Top250Movies/";
	private String fullAccessLink;
	private Parser parser = new Parser();
	private Consumer consumer = new Consumer();
	private HTMLGenerator HtmlGenerator;

	public ImdbApiClient(String apiKey, String htmlName) throws FileNotFoundException {
		this.fullAccessLink = this.ACCESS_LINK + apiKey;
		PrintWriter printWriter = new PrintWriter(new File(htmlName));
		this.HtmlGenerator = new HTMLGenerator(printWriter);
	}

	public String buildHtmlCode(){
		try {
			String json = this.consumer.getMoviesList(this.fullAccessLink);
			
			List<Movie> moviesList = this.parser.parseToMovie(json);
			
			this.HtmlGenerator.generate(moviesList);
		}catch(IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
		return "HTML criado com sucesso";
	}

}
