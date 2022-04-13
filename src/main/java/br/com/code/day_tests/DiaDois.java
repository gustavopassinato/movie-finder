package br.com.code.day_tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.code.data_processing.impl.Consumer;

public class DiaDois {

	public static void main(String[] args) throws IOException, InterruptedException {
		Consumer consumer = new Consumer();

		String json = consumer.getMoviesList("k_xj7sg1f9");

		String[] jsonToArray = parserToArray(json);

		int tituloFieldPos = 2;
		int anoFieldPos = 4;
		int urlImagemFieldPos = 5;
		int imdbRatingFieldPos = 7;

		List<String> parseTitulo = parseField(jsonToArray, tituloFieldPos);
		System.out.println(parseTitulo.size());

		List<String> parseAno = parseField(jsonToArray, anoFieldPos);
		System.out.println(parseAno.size());
		
		List<String> parseUrlImagem = parseField(jsonToArray, urlImagemFieldPos);
		System.out.println(parseUrlImagem.size());
		
		List<String> parseImdbRating = parseField(jsonToArray, imdbRatingFieldPos);
		System.out.println(parseImdbRating.size());
		
	}

	public static String[] parserToArray(String json) {

		int endLimit = 20;
		int beguinLimit = 10;

		String jsonFormatted = json.substring(beguinLimit, json.length() - endLimit);

		String[] moviesArray = jsonFormatted.split("},\\{");

		return moviesArray;
	}

	public static List<String> parseField(String[] moviesArray, int pos) {
		List<String> field = new ArrayList<String>();

		for (int i = 0; i < moviesArray.length; i++) {
			String[] moviesData = moviesArray[i].split("\",\"");
			String replaceAll = moviesData[pos].replaceAll("\"", "");
			String data = replaceAll.split(":", 2)[1];
			field.add(data);
		}
		return field;
	}
}
