package br.com.code.data_processing.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.code.model.Movie;

public class Parser {

	public final int TITLE_FIELD_POS = 2;
	public final int YEAR_FIELD_POS = 4;
	public final int IMAGE_URL_FIELD_POS = 5;
	public final int IMDB_RATING_FIELD_POS = 7;

	public String[] parserToArray(String json) {

		int endLimit = 20;
		int beguinLimit = 10;

		String jsonFormatted = json.substring(beguinLimit, json.length() - endLimit);

		String[] moviesArray = jsonFormatted.split("},\\{");

		return moviesArray;
	}

	public List<String> parseField(String[] moviesArray, int pos) {
		List<String> field = new ArrayList<String>();

		for (int i = 0; i < moviesArray.length; i++) {
			String[] moviesData = moviesArray[i].split("\",\"");
			String replaceAll = moviesData[pos].replaceAll("\"", "");
			String data = replaceAll.split(":", 2)[1];
			field.add(data);
		}
		return field;
	}

	public List<Movie> parseToMovie(String json) {
		List<Movie> moviesList = new ArrayList<Movie>();

		String[] jsonToArray = parserToArray(json);

		List<String> titleList = parseField(jsonToArray, TITLE_FIELD_POS);
		List<String> yearList = parseField(jsonToArray, YEAR_FIELD_POS);
		List<String> imagesList = parseField(jsonToArray, IMAGE_URL_FIELD_POS);
		List<String> imdbRatingList = parseField(jsonToArray, IMDB_RATING_FIELD_POS);

		if (titleList.size() == 250 && yearList.size() == 250 && imagesList.size() == 250
				&& imdbRatingList.size() == 250) {
			for (int i = 0; i < titleList.size(); i++) {
				Movie movie = new Movie(titleList.get(i), yearList.get(i), imagesList.get(i), imdbRatingList.get(i));
				moviesList.add(movie);
			}
			return moviesList;
		} else {
			throw new IllegalArgumentException("Lista com tamanho incorreto");
		}

	}
}
