package br.com.code.day_tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.code.data_processing.impl.Consumer;
import br.com.code.data_processing.impl.Parser;
import br.com.code.model.Movie;

public class DiaTres {

	public static void main(String[] args) throws IOException, InterruptedException {
		List<Movie> moviesList = new ArrayList<Movie>();
		
		Consumer consumer = new Consumer();
		
		Parser parser = new Parser();
		
		String json = consumer.getMoviesList("k_xj7sg1f9");
		
		String[] jsonToArray = parser.parserToArray(json);
		
		List<String> titleList = parser.parseField(jsonToArray, parser.TITLE_FIELD_POS);
		List<String> yearList = parser.parseField(jsonToArray, parser.YEAR_FIELD_POS);
		List<String> imagesList = parser.parseField(jsonToArray, parser.IMAGE_URL_FIELD_POS);
		List<String> imdbRatingList = parser.parseField(jsonToArray, parser.IMDB_RATING_FIELD_POS);
		
		if(titleList.size() == 250 && yearList.size() == 250 && imagesList.size() == 250 && imdbRatingList.size() == 250) {
			for(int i = 0 ; i < titleList.size(); i++) {
				Movie movie = new Movie(titleList.get(i), yearList.get(i), imagesList.get(i), imdbRatingList.get(i));
				moviesList.add(movie);
			}
		}else {
			throw new IllegalArgumentException("Lista com tamanho incorreto");
		}
		
		moviesList.forEach(System.out::println);
	}
}
